package com.financeira.entity;

import com.financeira.exception.EmprestimoNaoDisponivelException;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class Emprestimo {
	
	private Cliente cliente;
	
	public Emprestimo(Cliente cliente) {
		this.cliente = cliente;
	}
	
    //emprestimo pessoal
	public boolean emprestimoPessoalDisponivel() {
		if( cliente.rendaMenorQue(4000.0) && 
		 cliente.rendaEntreValor(1000.0, 4000.0) &&
		 cliente.idadeMaiorQue(30) && 
		 cliente.localizacaoCliente("Sp")) {
			 return true;
		}
		return false;
		
						
	}
	 //emprestimo pessoal
	public  double taxaJurosEmprestimoPessoal() {
		if(emprestimoPessoalDisponivel()) {
			return 4.0;
		}else {
			throw new EmprestimoNaoDisponivelException("Emprestimo Pessoal Não Disponivel");
		}
		
	}
	//emprstimo consignado
	public boolean emprestimoConsignado() {
		if(cliente.rendaIqualOuMaiorQue(5000.0) && cliente.idadeMaiorQue(40)){
			return true;
		}
		return false;
	}
	//emprstimo consignado
	public  double taxaJurosEmprestimoConsignado() {
		if(emprestimoConsignado()) {
			return 2.0;
		}else {
			throw new EmprestimoNaoDisponivelException("Emprestimo Consgnado Não Disponivel");
		}		
	}
	//emprstimo com Garantia
	public boolean emprestimoComGarantia() {
		  
	  if(cliente.rendaIqualOuMaiorQue(5000.0) &&
		 cliente.rendaEntreValor(5000.0, 8000.0) && 
		 cliente.idadeMaiorQue(30) && 
		 cliente.localizacaoCliente("Sp")) {
		   
			return true;
		}
		 return false;
	}
	public double taxajurosEmprestimoComGarantia() {
		if(emprestimoComGarantia()) {
		 return 3.0;
	}else {
		throw new EmprestimoNaoDisponivelException("Emprestimo Com Garantia Não Disponivel");
	}   
  }

}
