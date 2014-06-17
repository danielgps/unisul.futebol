package br.unisul.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.entity.Usuario;
import br.unisul.service.UsuarioService;
import br.unisul.service.exception.ServiceException;
import br.unisul.util.ExceptionUtil;

@WebServlet("/Logar")
public class LogarServlet extends HttpServlet {

	private static final long serialVersionUID = -5343974568885211174L;

	public LogarServlet() {

		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			UsuarioService service = new UsuarioService();

			String mail = request.getParameter("mail");
			String senha = request.getParameter("senha");

			Usuario usuario = service.find(mail, senha);

			if (usuario == null) {

				throw new ServiceException("E-mail ou senha incorreta");
			}

			request.getSession().setAttribute("user_logged", usuario);

			if (usuario.getPerfil().isAdmin()) {

				response.sendRedirect("/futebol/pages/private/home.jsp");
			} else {

				response.sendRedirect("/futebol/pages/public/index.jsp");
			}

		} catch (Exception e) {

			ExceptionUtil.handleException(e, request, "loginMessage");

			RequestDispatcher view = request.getRequestDispatcher("/pages/public/index.jsp");
			view.forward(request, response);
		}

	}
}
