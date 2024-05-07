package com.financeira.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.financeira.dto.ClienteRequestDto;
import com.financeira.dto.ClienteResponseDto;
import com.financeira.dto.EmprestimoResponse;
import com.financeira.entity.Cliente;
import com.financeira.entity.Emprestimo;
import com.financeira.enums.TipoEmprestimo;
import com.financeira.exception.EmprestimoNaoDisponivelException;
import com.financeira.service.EmprestimoService;

@Service
public class EmprestimoServiceImpl implements EmprestimoService{
	

	@Override
	public ClienteResponseDto emprestimoDisponivel(ClienteRequestDto request) {
		
		var clienteEmprestimo = request.converterCliente();
		var emprestimo = new Emprestimo(clienteEmprestimo);
		
		
		//retionado a lista de meprestimo
		List<EmprestimoResponse> emprestimos = new ArrayList<>();
		//aduicionando os emprstimos confoem a disponibilidade do  cliente
		if(emprestimo.emprestimoPessoalDisponivel()) {
			emprestimos.add(new EmprestimoResponse(TipoEmprestimo.Pessoal, emprestimo.taxaJurosEmprestimoPessoal()));		
		}
		
		if(emprestimo.emprestimoConsignado()) {
			emprestimos.add(new EmprestimoResponse(TipoEmprestimo.Consignado, emprestimo.taxaJurosEmprestimoConsignado()));
		}
		
		if(emprestimo.emprestimoComGarantia()) {
			emprestimos.add(new EmprestimoResponse(TipoEmprestimo.Guarantia, emprestimo.taxajurosEmprestimoComGarantia()));
		}
		if(emprestimos.isEmpty()) {
			throw  new EmprestimoNaoDisponivelException("O Cliente não satifaz os Requezitos pra Emprestimo");
		}
		
		return new ClienteResponseDto(request.getName(), emprestimos);
	
	}
 
}
