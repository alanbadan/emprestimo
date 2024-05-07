package com.financeira.dto;

import org.hibernate.validator.constraints.br.CPF;

import com.financeira.entity.Cliente;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClienteRequestDto {
	
	@Min(value = 18, message = "Emprestimo somente disponivel para maiores de 18 anos")
	@NotNull
	private Integer idade;
	@CPF
	private String cpf;
	@NotBlank
	private String name;
	@Min(value = 1000)
	@NotNull
	private Double renda;
	@NotBlank
	private String localizacao;
	
	
	public Cliente converterCliente() {
		Cliente cliente = new Cliente();
		cliente.setIdade(idade);
		cliente.setCpf(cpf);
		cliente.setName(name);
		cliente.setRenda(renda);
		cliente.setLocalizacao(localizacao);
		return cliente;
		
	}

}
