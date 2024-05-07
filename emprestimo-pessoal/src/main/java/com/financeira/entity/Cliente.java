package com.financeira.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {
	
	
	private Integer idade;
	private String cpf;
	private String name;
	private Double renda;
	private String localizacao;
	
	
	 public Cliente() {
	 }
		
	public Cliente(Integer idade, String cpf, String name, Double renda, String localizacao) {
		super();
		this.idade = idade;
		this.cpf = cpf;
		this.name = name;
		this.renda = renda;
		this.localizacao = localizacao;
	}


//pessoal
public boolean rendaMenorQue(double valor) {
	 return renda < valor; 
  }
//consignado
public boolean rendaIqualOuMaiorQue(double valor) {
	return renda >= valor;
}
 
 public boolean rendaEntreValor(double minValor, double maxValor) {
	 return renda >= minValor && renda <= maxValor;
 }
 
 public boolean idadeMaiorQue(int idadeCliente) {
	 return idade > idadeCliente;
 }
 
 public boolean localizacaoCliente(String localizacaoCliente) {
	 return this.localizacao.equalsIgnoreCase(localizacaoCliente);
 }

}