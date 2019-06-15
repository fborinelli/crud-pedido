package br.com.vv.domain;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class ClienteTest {

	@Test
	public void deveCriarObjetoCliente() {
		String uuid = UUID.randomUUID().toString();
		String nome = "RONALDO";
		LocalDate dataNascimento = LocalDate.of(1980, 1, 1);
		
		Cliente cliente = new Cliente();
		cliente.setCodigo(uuid);
		cliente.setNome(nome);
		cliente.setDataNascimento(dataNascimento);
		
		Assert.assertEquals(uuid, cliente.getCodigo());
		Assert.assertEquals(nome, cliente.getNome());
		Assert.assertEquals(dataNascimento, cliente.getDataNascimento());
	}

}
