package com.financeira.serviceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.financeira.builder.ClienteBuilder;
import com.financeira.builder.ClienteRequestDtoTest;
import com.financeira.dto.ClienteRequestDto;
import com.financeira.dto.ClienteResponseDto;
import com.financeira.dto.EmprestimoResponse;
import com.financeira.entity.Emprestimo;
import com.financeira.enums.TipoEmprestimo;
import com.financeira.service.EmprestimoService;

@ExtendWith(MockitoExtension.class)
public class EmprestimoServiceImplTest {
	
	@Mock
	EmprestimoService emprestimoService;
	
	@Mock
	Emprestimo emprestimo;
	
	@Mock
	ClienteResponseDto responseDto;
	
	@Mock 
	ClienteRequestDto dto;
	
	@Mock
	TipoEmprestimo tipoEmprestimo;
	
	
	
	@Test
	void deveriaRetornarNomeClienteEDisponibilidadeDeEmprestimo() {
		var tipo = TipoEmprestimo.Pessoal;
		ClienteRequestDto cliente = new ClienteRequestDto(31, "907.657.990-30", "Carlos Andre", 2000.0, "Sp");
		var clienteEmprestimo = cliente.converterCliente();
		var emprestimo = new Emprestimo(clienteEmprestimo); 

		EmprestimoResponse response = EmprestimoResponse.builder()
				                      .taxaJuros(4.0)
				                      .tipoEmprestimo(TipoEmprestimo.Pessoal)
				                      .build();
		
		List<EmprestimoResponse> list = new ArrayList<>();
		when(emprestimo.emprestimoPessoalDisponivel()).thenReturn(list.add(response));
//		list.add(response);
//		when(responseDto.getEmprestimo()).thenReturn(list);
		assertThat(list).isNotEmpty().isNotNull();
		assertTrue(emprestimo.emprestimoPessoalDisponivel());
		assertEquals(emprestimo.taxaJurosEmprestimoPessoal(), response.getTaxaJuros());
		assertEquals(response.getTipoEmprestimo(), tipo);
		assertEquals("Carlos Andre", emprestimo.getCliente().getName());
		
		
		
	}
	

}
