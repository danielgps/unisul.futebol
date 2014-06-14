package br.unisul.service.exception;

import java.util.ArrayList;
import java.util.List;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = -1383690648865497415L;

	private List<String> messages = new ArrayList<String>();
	
	public String getDefaultMessage(){
		
		return "Ocorreu um erro ao realizar a operação, tente novamente";
	}

	public ServiceException() {

		super();
	}

	public ServiceException(List<String> messages, Throwable cause) {

		super(cause);

		this.messages = messages;
	}

	public ServiceException(String message, Throwable cause) {

		super(message, cause);

		messages.add(message);
	}

	public ServiceException(String message) {

		super(message);

		messages.add(message);
	}

	public ServiceException(Throwable cause) {

		super(cause);
	}

	public List<String> getMessages() {

		return messages;
	}

	public void setMessages(List<String> messages) {

		this.messages = messages;
	}
	
}
