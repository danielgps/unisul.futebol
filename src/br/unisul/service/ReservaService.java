package br.unisul.service;

import java.util.List;

import br.unisul.entity.Reserva;
import br.unisul.service.exception.ServiceException;

public class ReservaService extends BaseService {

	public void save(Reserva reserva) throws ServiceException {

	}

	public void edit(Reserva reserva) throws ServiceException {

	}

	public void delete(Long idReserva) throws ServiceException {

	}

	@SuppressWarnings("unchecked")
	public List<Reserva> list() {

		return (List<Reserva>) listByQuery("SELECT r FROM Reserva r ORDER BY r.dataReserva DESC");
	}
	
	@SuppressWarnings("unchecked")
	public List<Reserva> list(Long idUsuario) {
		
		return (List<Reserva>) listByQuery("SELECT r FROM Reserva r INNER JOIN FETCH r.usuario u WHERE u.id = ? AND r.dataReserva > CURRENT_DATE() ORDER BY r.dataReserva DESC", idUsuario);
	}
}
