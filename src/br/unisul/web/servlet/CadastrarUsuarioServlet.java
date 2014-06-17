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

@WebServlet("/CadastrarAction")
public class CadastrarUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = -5343974568885211174L;

	public CadastrarUsuarioServlet() {

		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			UsuarioService service = new UsuarioService();

			String mail = request.getParameter("mail");
			String senha = request.getParameter("senha");
			String nome = request.getParameter("nome");
			String telefone = request.getParameter("telefone");

			Usuario usuario = new Usuario();
			usuario.setMail(mail);
			usuario.setSenha(senha);
			usuario.setNome(nome);
			usuario.setTelefone(telefone);

			service.save(usuario);

			request.getSession().setAttribute("user_logged", service.find(mail, senha));

			response.sendRedirect("/futebol/pages/private/home.jsp");

		} catch (Exception e) {

			ExceptionUtil.handleException(e, request);

			RequestDispatcher view = request.getRequestDispatcher("/pages/public/usuario/cadastro-usuario.jsp");
			view.forward(request, response);

		}
	}
}
