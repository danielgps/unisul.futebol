package br.unisul.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.entity.Campo;
import br.unisul.entity.enun.TipoCampo;
import br.unisul.service.CampoService;
import br.unisul.util.ExceptionUtil;

@WebServlet("/CadastrarCampoAction")
public class CadastrarCampoServlet extends HttpServlet {

	private static final long serialVersionUID = -5343974568885211174L;

	public CadastrarCampoServlet() {

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
			
			request.setAttribute("messages", "Campo cadastrado com sucesso");

			RequestDispatcher view = request.getRequestDispatcher("/pages/private/campo/list-campo.jsp");
			view.forward(request, response);

		} catch (Exception e) {

			ExceptionUtil.handleException(e, request);

			RequestDispatcher view = request.getRequestDispatcher("/pages/private/campo/save-campo.jsp");
			view.forward(request, response);

		}

	}
}
