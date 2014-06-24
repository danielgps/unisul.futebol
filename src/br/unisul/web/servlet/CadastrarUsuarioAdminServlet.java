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

@WebServlet("/CadastrarUsuarioAdminAction")
public class CadastrarUsuarioAdminServlet extends HttpServlet {

	private static final long serialVersionUID = -5343974568885211174L;

	public CadastrarUsuarioAdminServlet() {

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
			String perfil = request.getParameter("perfil");
			
			Usuario usuario = new Usuario();
			usuario.setMail(mail);
			usuario.setSenha(senha);
			usuario.setNome(nome);
			usuario.setTelefone(telefone);
			usuario.setPerfil( service.findPerfil(Long.valueOf(perfil)));

			service.saveAdmin(usuario);

            request.setAttribute("messages", "Usuario cadastrado com sucesso");

            RequestDispatcher view = request.getRequestDispatcher("/pages/private/usuario/list-usuario.jsp");
            view.forward(request, response);

		} catch (Exception e) {

			ExceptionUtil.handleException(e, request);

			RequestDispatcher view = request.getRequestDispatcher("/pages/private/usuario/save-usuario.jsp");
			view.forward(request, response);

		}
	}
}
