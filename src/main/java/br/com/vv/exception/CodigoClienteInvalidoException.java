package br.com.vv.exception;

public class CodigoClienteInvalidoException extends RuntimeException {

	public CodigoClienteInvalidoException() {
	}

	public CodigoClienteInvalidoException(String message) {
		super(message);
	}

	public CodigoClienteInvalidoException(Throwable cause) {
		super(cause);
	}

	public CodigoClienteInvalidoException(String message, Throwable cause) {
		super(message, cause);
	}

	public CodigoClienteInvalidoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
