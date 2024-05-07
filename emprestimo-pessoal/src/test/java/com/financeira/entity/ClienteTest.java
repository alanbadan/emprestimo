package com.financeira.entity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.financeira.builder.ClienteBuilder;

@ExtendWith(MockitoExtension.class)
public class ClienteTest {

	
	@Test
	void deveriaRetonarTrueRendaMenorQue() {
		var cliente = ClienteBuilder.build(2000.0);
		assertTrue(cliente.rendaMenorQue(3000.0));
	}
	
	@Test
	void deveriaRetornarFalseMenorQue() {
		var cliente = ClienteBuilder.build(4000.0);
		assertFalse(cliente.rendaMenorQue(3000.0));
	}
	
	@Test 
	void deveriaRetornarTrueRendaMaiorOuIgualQue() {
		var clienteIgual = ClienteBuilder.build(5000.0);
		var clienteMaior = ClienteBuilder.build(5000.0);
		assertTrue(clienteIgual.rendaIqualOuMaiorQue(5000.0));
		assertTrue(clienteMaior.rendaIqualOuMaiorQue(4000.0));
		
	}
	@Test 
	void deveriaRetonarFalseRendaMaiorOuIgual(){
		var clienteIgual = ClienteBuilder.build(5000.0);
		var clienteMaior = ClienteBuilder.build(5000.0);
		assertFalse(clienteIgual.rendaIqualOuMaiorQue(6000.0));
		assertFalse(clienteMaior.rendaIqualOuMaiorQue(6000.0));
	}
	
	@Test
	void deveriaRetornarTrueRendaEntreValores() {
		var cliente = ClienteBuilder.build(5000.0);
		assertTrue(cliente.rendaEntreValor(1000.0, 6000.0));
	}
	
	@Test
	void deveriaRetornarFalseRendaEntreValores() {
		var cliente = ClienteBuilder.build(3000.0);
		assertFalse(cliente.rendaEntreValor(4000.0, 6000.0));
	}
	
	@Test
	void deveriaRetornarTrueIdadeMaiorQue() {
		var cliente = ClienteBuilder.build();
		assertTrue(cliente.idadeMaiorQue(30));
	}
	
	@Test
	void deveriaRetornarFalseIdadeMaiorQue() {
		var cliente = ClienteBuilder.build();
		assertFalse(cliente.idadeMaiorQue(32));
	}
	
	@Test
	void deveriaRetornarTrueLocalizacao() {
		var cliente = ClienteBuilder.build();
		assertTrue(cliente.localizacaoCliente("Sp"));
	}
	
	@Test
	void deveriaRetornarFalseLocalizacao() {
		var cliente = ClienteBuilder.build();
		assertFalse(cliente.localizacaoCliente("Sc"));
	}
}
