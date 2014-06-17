package br.unisul.util;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import br.unisul.service.exception.ServiceException;

public class ExceptionUtil {

	public static void handleException(Exception e, HttpServletRequest request) {

		handleException(e, request, "messages");
	}

	public static void handleException(Exception e, HttpServletRequest request, String attribute) {

		if (e instanceof ServiceException) {

			request.setAttribute(attribute, ((ServiceException) e).getMessages());
		} else {

			request.setAttribute(attribute, Arrays.asList(ServiceException.getDefaultMessage()));
		}

	}

}
