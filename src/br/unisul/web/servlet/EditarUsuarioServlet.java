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

@WebServlet("/EditarUsuarioAction")
public class EditarUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = -5343974568885211174L;

	public EditarUsuarioServlet() {

		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			UsuarioService service = new UsuarioService();

			String id = request.getParameter("id");
			String senha = request.getParameter("senha");
			String nome = request.getParameter("nome");
			String telefone = request.getParameter("telefone");
			
			Usuario usuario = service.find(Long.valueOf(id));
			
			if(usuario == null){
				
				throw new ServiceException("Ocorreu um erro");
			}
			
			usuario.setSenha(senha);
			usuario.setNome(nome);
			usuario.setTelefone(telefone);

			service.edit(usuario.getId(), senha, nome, telefone);

            request.setAttribute("messages", "Usuario editado com sucesso");

            RequestDispatcher view = request.getRequestDispatcher("/pages/private/usuario/list-usuario.jsp");
            view.forward(request, response);

		} catch (Exception e) {

			ExceptionUtil.handleException(e, request);

			RequestDispatcher view = request.getRequestDispatcher("/pages/private/usuario/list-usuario.jsp");
			view.forward(request, response);

		}

	}
}
