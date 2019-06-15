package br.com.vv.service;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.vv.domain.Cliente;
import br.com.vv.exception.Menor18AnosException;
import br.com.vv.repository.ClienteRepository;

@RunWith(MockitoJUnitRunner.class)
public class ClienteServiceTest {

	@InjectMocks
	private ClienteService service;
	
	@Mock
	private ClienteRepository repository;
	
	@Before
	public void setup() {
		
	}

	@Test
	public void deveCriarCliente() {
		Cliente cliente = new Cliente();
		cliente.setNome("RONALDO");
		cliente.setDataNascimento(LocalDate.of(1980, 01, 01));
		
		Mockito.when(repository.save(cliente)).thenReturn(cliente);
		
		cliente = service.criarCliente(cliente);
		Assert.assertNotNull(cliente);
		Assert.assertNotNull(cliente.getCodigo());
	}
	
	@Test(expected = Menor18AnosException.class)
	public void naoDeveCriarClienteMenor18Anos() {
		Cliente cliente = new Cliente();
		cliente.setNome("RONALDO");
		cliente.setDataNascimento(LocalDate.of(2004, 01, 01));
		service.criarCliente(cliente);
	}

}
