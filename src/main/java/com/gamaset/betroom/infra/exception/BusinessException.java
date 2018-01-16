package com.gamaset.betroom.infra.exception;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
public class BusinessException extends RuntimeException{

	
	private static final long serialVersionUID = -4885177945079359790L;

	/**
	 * business constructor
	 */
	public BusinessException() {
		super();
	}

	/**
	 * 
	 * @param message
	 */
	public BusinessException(final String message) {
		super(message);
	}

	/**
	 * 
	 * @param message
	 * @param cause
	 */
	public BusinessException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * 
	 * @param cause
	 */
	public BusinessException(final Throwable cause) {
		super(cause);
	}

}
