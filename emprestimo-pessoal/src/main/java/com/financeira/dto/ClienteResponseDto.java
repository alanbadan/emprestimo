package com.financeira.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteResponseDto {
	
	private String name;
	private List<EmprestimoResponse> emprestimo;
	
	public ClienteResponseDto() {
		
	}

	public ClienteResponseDto(String name, List<EmprestimoResponse> emprestimo) {
		super();
		this.name = name;
		this.emprestimo = emprestimo;
	}

	
}
