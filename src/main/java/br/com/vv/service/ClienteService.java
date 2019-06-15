package br.com.vv.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.vv.domain.Cliente;
import br.com.vv.exception.ClienteNaoEncontradoException;
import br.com.vv.exception.CodigoClienteInvalidoException;
import br.com.vv.exception.DataInvalidaException;
import br.com.vv.exception.Menor18AnosException;
import br.com.vv.exception.NomeClienteInvalidoException;
import br.com.vv.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	/**
	 * Cria o cliente realizando as validações necessárias (nome válido e maior de
	 * 18 anos)
	 * 
	 * @param cliente
	 * @return {@link Cliente}
	 */
	public Cliente criarCliente(Cliente cliente) {
		cliente.setCodigo(UUID.randomUUID().toString());
		validarCliente(cliente);
		return repository.save(cliente);
	}

	/**
	 * Atualiza cliente validando nome, data nascimento e existencia do mesmo
	 * 
	 * @param cliente
	 * @return {@link Cliente}
	 */
	public Cliente atualizarCliente(Cliente cliente) {
		validarCliente(cliente);
		validarClienteExiste(cliente.getCodigo());
		return repository.save(cliente);
	}

	/**
	 * Remove o cliente
	 * 
	 * @param codigo
	 */
	public void deletarCliente(String codigo) {
		validarClienteExiste(codigo);
		repository.deleteById(codigo);
	}

	/**
	 * Realiza busca do cliente pelo código
	 * 
	 * @param codigo
	 * @return {@link Cliente}
	 */
	public Cliente buscarPorCodigo(String codigo) {
		return repository.findById(codigo).orElse(null);
	}

	/**
	 * Buscar todos os clientes
	 * 
	 * @return {@link List}
	 */
	// TODO: Mudar para paginado
	public List<Cliente> buscarTodos() {
		return repository.findAll();
	}

	private void validarClienteExiste(String codigo) {
		if (!StringUtils.isEmpty(codigo) && !repository.findById(codigo).isPresent()) {
			throw new ClienteNaoEncontradoException("Cliente com código " + codigo + " não encontrado");
		} else if (StringUtils.isEmpty(codigo)) {
			throw new CodigoClienteInvalidoException("Código não pode ser vazio");
		}
	}

	private void validarCliente(Cliente cliente) {
		validarNomeCliente(cliente);
		validarMaior18Anos(cliente);
	}

	private void validarMaior18Anos(Cliente cliente) {
		if (Objects.isNull(cliente.getDataNascimento())) {
			throw new DataInvalidaException("A data não pode ser nula");
		}

		long anos = ChronoUnit.YEARS.between(cliente.getDataNascimento(),LocalDate.now());

		if (anos < 18) {
			throw new Menor18AnosException("Cliente menor de 18 anos. Anos atuais = " + anos);
		}
	}

	private void validarNomeCliente(Cliente cliente) {
		// validação do nome do cliente
		if (StringUtils.isEmpty(cliente.getNome()) || cliente.getNome().length() < 5) {
			throw new NomeClienteInvalidoException("Nome do cliente inválido " + "(" + cliente.getNome() + ")");
		}
	}

}
