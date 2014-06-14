package br.unisul.web.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.entity.Campo;
import br.unisul.entity.enun.TipoCampo;
import br.unisul.service.CampoService;
import br.unisul.service.exception.ServiceException;

@WebServlet("/CadastrarAction")
public class CadastrarCampo extends HttpServlet {

	private static final long serialVersionUID = -5343974568885211174L;

	public CadastrarCampo() {

		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			CampoService service = new CampoService();

			String nome = request.getParameter("nome");
			String descricao = request.getParameter("descricao");
			String tipo = request.getParameter("tipo");

			Campo campo = new Campo();
			campo.setNome(nome);
			campo.setDescricao(descricao);
			campo.setTipo(TipoCampo.getByString(tipo));

			service.save(campo);

			request.setAttribute("usuario", campo);

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
