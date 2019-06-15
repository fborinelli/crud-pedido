package br.com.vv.exception;

public class ClienteNaoEncontradoException extends RuntimeException {


	public ClienteNaoEncontradoException(String message) {
		super(message);
	}

	public ClienteNaoEncontradoException(Throwable cause) {
		super(cause);
	}

	public ClienteNaoEncontradoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ClienteNaoEncontradoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
