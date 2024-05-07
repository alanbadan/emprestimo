package com.financeira.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.financeira.exception.EmprestimoNaoDisponivelException;

@ExtendWith(MockitoExtension.class)
public class EmprestimoTest {
	
	@Mock
	private Cliente cliente;
	
	@InjectMocks
	private Emprestimo emprestimo;
	
	@Test
	void deveriaRetornarTrueEmprestimoPessoal() {
		when(cliente.rendaMenorQue(4000.0)).thenReturn(true);
		when(cliente.rendaEntreValor(1000.0, 4000.0)).thenReturn(true);
		when(cliente.idadeMaiorQue(30)).thenReturn(true);
		when(cliente.localizacaoCliente("Sp")).thenReturn(true);
		
		assertTrue(emprestimo.emprestimoPessoalDisponivel());
		verifyNoMoreInteractions(cliente);
		
	}
     
	@Test
	void deveriaRetornarFalseEmprestimoPessoal() {
		when(cliente.rendaMenorQue(4000.0)).thenReturn(false);
		
		assertFalse(emprestimo.emprestimoPessoalDisponivel());
		verifyNoMoreInteractions(cliente);
		
	}
	
	@Test
	void deveriaRetornarTrueEmprestimoConsignado() {
		when(cliente.rendaIqualOuMaiorQue(5000.0)).thenReturn(true);
		when(cliente.idadeMaiorQue(40)).thenReturn(true);
		
		assertTrue(emprestimo.emprestimoConsignado());
		verifyNoMoreInteractions(cliente);
	}
	
	@Test
	void deveriaRetornarFalseEmprestimoConsignado() {
		when(cliente.rendaIqualOuMaiorQue(5000.0)).thenReturn(false);
				
		assertFalse(emprestimo.emprestimoConsignado());
		verifyNoMoreInteractions(cliente);
	}
	
	@Test
	void deveriaRetornarTrueEmprestimoComGarantia() {
		
		when(cliente.rendaIqualOuMaiorQue(5000.0)).thenReturn(true);
		when(cliente.rendaEntreValor(5000.0, 8000.0)).thenReturn(true);
		when(cliente.idadeMaiorQue(30)).thenReturn(true);
		when(cliente.localizacaoCliente("Sp")).thenReturn(true);
		
		assertTrue(emprestimo.emprestimoComGarantia());
		verifyNoMoreInteractions(cliente);
		
	}
	@Test
	void deveriaRetornarFalseEmprestimoComGarantia() {
		when(cliente.rendaIqualOuMaiorQue(5000.0)).thenReturn(false);
		
		assertFalse(emprestimo.emprestimoComGarantia());
		verifyNoMoreInteractions(cliente);
        
	}
	
	//taxa de juros
	@Test
	void deveriaRetornarTaxaJurosEmprestimoPessoal() {
		double taxa = 4.0;
		when(cliente.rendaMenorQue(4000.0)).thenReturn(true);
		when(cliente.rendaEntreValor(1000.0, 4000.0)).thenReturn(true);
		when(cliente.idadeMaiorQue(30)).thenReturn(true);
		when(cliente.localizacaoCliente("Sp")).thenReturn(true);
		
		assertTrue(emprestimo.emprestimoPessoalDisponivel());	
		assertEquals(taxa, emprestimo.taxaJurosEmprestimoPessoal());
	}
	
	@Test
	void deveriaRetornarExcecaoCasoNaoAprovadoEmpPessoal() {
		
		when(cliente.rendaMenorQue(4000.0)).thenReturn(false);
	
		assertFalse(emprestimo.emprestimoPessoalDisponivel());	
		assertThrows(EmprestimoNaoDisponivelException.class, () -> emprestimo.taxaJurosEmprestimoPessoal());
	}
	
	@Test 
	void deveriaRetornarTaxaJurosEmpConsignado(){
		double taxa = 2.0;
		
		when(cliente.rendaIqualOuMaiorQue(5000.0)).thenReturn(true);
		when(cliente.idadeMaiorQue(40)).thenReturn(true);
		
		assertTrue(emprestimo.emprestimoConsignado());
		assertEquals(taxa, emprestimo.taxaJurosEmprestimoConsignado());
		
	}
	
	@Test
	void deveriaRetornarExcecaoCasoNaoAprovadoEmrestimoConsg() {
		
		when(cliente.rendaIqualOuMaiorQue(5000.0)).thenReturn(false);
	
		assertFalse(emprestimo.emprestimoPessoalDisponivel());	
		assertThrows(EmprestimoNaoDisponivelException.class, () -> emprestimo.taxaJurosEmprestimoConsignado());
	}
	
	@Test
	void deveriaRetornarTaxaJurosEmpGuarantia() {
		double taxa = 3.0;
		
	    when(cliente.rendaIqualOuMaiorQue(5000.0)).thenReturn(true);
	    when(cliente.rendaEntreValor(5000.0, 8000.0)).thenReturn(true);
	    when(cliente.idadeMaiorQue(30)).thenReturn(true);
	    when(cliente.localizacaoCliente("Sp")).thenReturn(true);
	
	    assertTrue(emprestimo.emprestimoComGarantia());
	    assertEquals(taxa, emprestimo.taxajurosEmprestimoComGarantia());
	}	
	
	@Test
	void deveriaRetornarExcecaoCasoNaoAprovadoEmrestismoGarantia() {
		
		when(cliente.rendaIqualOuMaiorQue(5000.0)).thenReturn(false);
	
		assertFalse(emprestimo.emprestimoPessoalDisponivel());	
		assertThrows(EmprestimoNaoDisponivelException.class, () -> emprestimo.taxajurosEmprestimoComGarantia());
	}
}
