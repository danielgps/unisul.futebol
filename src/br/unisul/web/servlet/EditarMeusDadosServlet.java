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
import br.unisul.util.ExceptionUtil;

@WebServlet("/EditarMeusDados")
public class EditarMeusDadosServlet extends HttpServlet {

	private static final long serialVersionUID = -5343974568885211174L;

	public EditarMeusDadosServlet() {

		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UsuarioService service = new UsuarioService();
		Usuario usuario = (Usuario) request.getSession().getAttribute("user_logged");

		try {

			String mail = request.getParameter("mail");
			String senha = request.getParameter("senha");
			String nome = request.getParameter("nome");
			String telefone = request.getParameter("telefone");

			service.edit(usuario.getId(), senha, nome, telefone);

			usuario = service.find(mail, senha);

			request.getSession().setAttribute("user_logged", usuario);

			response.sendRedirect("/futebol/pages/private/usuario/meus-dados.jsp");

		} catch (Exception e) {

			ExceptionUtil.handleException(e, request);

			RequestDispatcher view = null;

			if (usuario == null) {

				view = request.getRequestDispatcher("/pages/public/index.jsp");
			} else {

				view = request.getRequestDispatcher("/pages/private/usuario/meus-dados.jsp");
			}

			view.forward(request, response);
		}

	}
}
