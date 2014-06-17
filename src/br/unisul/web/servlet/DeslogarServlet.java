package br.unisul.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Deslogar")
public class DeslogarServlet extends HttpServlet {

	private static final long serialVersionUID = -5343974568885211174L;

	public DeslogarServlet() {

		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getSession().setAttribute("user_logged", null);
		response.sendRedirect("/futebol/pages/public/index.jsp");
	}
}
