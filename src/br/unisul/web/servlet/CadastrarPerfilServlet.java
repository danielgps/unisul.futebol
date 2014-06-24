package br.unisul.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.entity.Perfil;
import br.unisul.service.PerfilService;
import br.unisul.util.ExceptionUtil;

@WebServlet("/CadastrarPerfilAction")
public class CadastrarPerfilServlet extends HttpServlet {

    private static final long serialVersionUID = -5343974568885211174L;

    public CadastrarPerfilServlet() {

        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            PerfilService service = new PerfilService();

            String nome = request.getParameter("nome");

            Perfil perfil = new Perfil();
            perfil.setNome(nome);

            service.save(perfil);

            request.setAttribute("messages", "Perfil cadastrado com sucesso");

            RequestDispatcher view = request.getRequestDispatcher("/pages/private/perfil/list-perfil.jsp");
            view.forward(request, response);

        } catch (Exception e) {

            ExceptionUtil.handleException(e, request);

            RequestDispatcher view = request.getRequestDispatcher("/pages/public/perfil/save-perfil.jsp");
            view.forward(request, response);

        }
    }
}
