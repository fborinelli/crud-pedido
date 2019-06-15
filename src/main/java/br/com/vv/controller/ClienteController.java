package br.com.vv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.vv.domain.Cliente;
import br.com.vv.service.ClienteService;

/*
 * GET http://localhost:8080/clientes/AUSDUASDI121231
 * */
@RestController("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping("/{codigo}")
	public void buscarClientePorCodigo(@RequestParam("codigo") String codigo) {
		Cliente cliente = service.buscarPorCodigo(codigo);
	}

}
