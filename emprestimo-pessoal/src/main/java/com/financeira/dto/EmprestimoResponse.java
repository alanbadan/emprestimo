package com.financeira.dto;

import com.financeira.enums.TipoEmprestimo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter	
@Builder
public class EmprestimoResponse {
	
	private TipoEmprestimo tipoEmprestimo;
	private Double taxaJuros;

}
