package com.financeira.exception;

public class EmprestimoNaoDisponivelException  extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public EmprestimoNaoDisponivelException(String mensagem) {
		super(mensagem);
	}

}
