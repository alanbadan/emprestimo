package com.financeira.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financeira.dto.ClienteRequestDto;
import com.financeira.dto.ClienteResponseDto;
import com.financeira.exception.EmprestimoNaoDisponivelException;
import com.financeira.service.EmprestimoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "cliente")
public class ClienteController {
	
	@Autowired
	EmprestimoService emprestimoService;
	
	
	@PostMapping("/emprestimo")
	public ResponseEntity<?> clienteEmprestimo(@RequestBody @Valid  ClienteRequestDto request){
		
		try {
			var emprestimoResponse = emprestimoService.emprestimoDisponivel(request);
			return ResponseEntity.ok(emprestimoResponse);
				
		}catch(EmprestimoNaoDisponivelException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		
	   }
		}
}
