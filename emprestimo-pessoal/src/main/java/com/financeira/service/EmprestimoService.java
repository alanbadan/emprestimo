package com.financeira.service;

import com.financeira.dto.ClienteRequestDto;
import com.financeira.dto.ClienteResponseDto;
import com.financeira.entity.Cliente;


public interface EmprestimoService {
	
 ClienteResponseDto emprestimoDisponivel(ClienteRequestDto request);
 	
 }
