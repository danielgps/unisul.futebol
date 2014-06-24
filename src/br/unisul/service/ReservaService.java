package br.unisul.service;

import java.util.Calendar;
import java.util.List;

import br.unisul.entity.Campo;
import br.unisul.entity.Reserva;
import br.unisul.entity.Usuario;
import br.unisul.service.exception.ServiceException;

public class ReservaService extends BaseService {

    public void save(Reserva reserva) throws ServiceException {

        if (reserva.getCampo() == null) {
            
            throw new ServiceException("Informe o campo");
        }

        if (reserva.getDataReserva() == null) {

            throw new ServiceException("Informe a dia da reserva");
        }

        if (reserva.getHoraReserva() == null) {

            throw new ServiceException("Informe a hora da reserva");
        }
        
        if (reserva.getUsuario() == null) {
            
            throw new ServiceException("Ocorreu um erro ao cadastrar, usuario nulo");
        }

        Reserva _reserva = (Reserva) oneByQuery("SELECT r FROM Reserva r WHERE r.campo.id = ? AND r.dataReserva = ? AND r.horaReserva = ?", reserva.getCampo().getId(), reserva.getDataReserva(),
                reserva.getHoraReserva());

        if (_reserva != null) {

            throw new ServiceException("Já existe reserva neste campo na data escolhida");
        }

        reserva.setDataCadastro(Calendar.getInstance());
        reserva.setCampo( getEntityManager().find(Campo.class, reserva.getCampo().getId()));
        reserva.setUsuario(getEntityManager().find(Usuario.class, reserva.getUsuario().getId()));

        super.save(reserva);
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

        return (List<Reserva>) listByQuery("SELECT r FROM Reserva r INNER JOIN FETCH r.usuario u WHERE u.id = ? ORDER BY r.dataReserva DESC", idUsuario);
    }
}
