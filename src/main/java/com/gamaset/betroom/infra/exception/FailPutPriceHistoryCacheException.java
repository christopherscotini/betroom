package com.gamaset.betroom.infra.exception;

public class FailPutPriceHistoryCacheException extends RuntimeException{
	
	private static final long serialVersionUID = -4119457690057006775L;

	public FailPutPriceHistoryCacheException() {
		super();
	}

	public FailPutPriceHistoryCacheException(String message, Throwable cause) {
		super(message, cause);
	}

	public FailPutPriceHistoryCacheException(String message) {
		super(message);
	}

	public FailPutPriceHistoryCacheException(Throwable cause) {
		super(cause);
	}

}
