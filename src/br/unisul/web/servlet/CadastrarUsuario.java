package br.unisul.web.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.entity.Usuario;
import br.unisul.service.UsuarioService;
import br.unisul.service.exception.ServiceException;

@WebServlet("/CadastrarAction")
public class CadastrarUsuario extends HttpServlet {

	private static final long serialVersionUID = -5343974568885211174L;

	public CadastrarUsuario() {

		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UsuarioService service = new UsuarioService();

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String nome = request.getParameter("nome");
		String telefone = request.getParameter("telefone");
		String mail = request.getParameter("mail");

		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		usuario.setNome(nome);
		usuario.setTelefone(telefone);
		usuario.setMail(mail);

		try {

			service.save(usuario);

			request.setAttribute("usuario", usuario);

			RequestDispatcher view = request.getRequestDispatcher("/pages/public/usuario/cadastro-usuario-result.jsp");
			view.forward(request, response);

		} catch (Exception e) {

			if (e instanceof ServiceException) {

				request.setAttribute("errorMessages", ((ServiceException) e).getMessages());
			} else {

				request.setAttribute("errorMessages", Arrays.asList(((ServiceException) e).getDefaultMessage()));
			}

			RequestDispatcher view = request.getRequestDispatcher("/pages/public/usuario/cadastro-usuario.jsp");
			view.forward(request, response);

		}

	}
}
