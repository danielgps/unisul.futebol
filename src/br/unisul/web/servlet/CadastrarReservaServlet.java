package br.unisul.web.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.entity.Reserva;
import br.unisul.entity.Usuario;
import br.unisul.entity.enun.HorarioReserva;
import br.unisul.service.CampoService;
import br.unisul.service.ReservaService;
import br.unisul.util.ExceptionUtil;

@WebServlet("/CadastrarReservaAction")
public class CadastrarReservaServlet extends HttpServlet {

	private static final long serialVersionUID = -5343974568885211174L;

	public CadastrarReservaServlet() {

		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
		    
			ReservaService service = new ReservaService();
			CampoService campoService = new CampoService();

			String campo = request.getParameter("campo");
			String data = request.getParameter("data");
			String hora = request.getParameter("hora");
			
			DateFormat formatter = new SimpleDateFormat("dd/mm/yy");
			
			Calendar _data = Calendar.getInstance();
			_data.setTime((Date)formatter.parse(data));
			
			Usuario usuario = (Usuario) request.getSession().getAttribute("user_logged");
			
			Reserva reserva = new Reserva();
			reserva.setHoraReserva(HorarioReserva.getByString(hora));
			reserva.setUsuario( usuario);
			reserva.setDataReserva(_data);
			reserva.setCampo( campoService.find( Long.valueOf( campo )));

			service.save(reserva);
			
			request.setAttribute("messages", "Reserva cadastrada com sucesso");

			RequestDispatcher view = request.getRequestDispatcher("/pages/private/home.jsp");
			view.forward(request, response);

		} catch (Exception e) {

			ExceptionUtil.handleException(e, request);

			RequestDispatcher view = request.getRequestDispatcher("/pages/private/reserva/save-reserva.jsp");
			view.forward(request, response);

		}

	}
}
