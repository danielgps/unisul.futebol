package br.unisul.service;

import java.util.List;

import br.unisul.entity.Campo;
import br.unisul.service.exception.ServiceException;

public class CampoService extends BaseService {

	public void save(Campo campo) {

		if (campo.getNome() == null || campo.getNome().trim().equalsIgnoreCase("")) {

			throw new ServiceException("Informe o nome do campo");
		}

		if (campo.getTipo() == null) {

			throw new ServiceException("Informe o nome do campo");
		}

		super.save(campo);
	}

	public void edit(Campo campo) {

	}

	public void delete(Long idCampo) {

	}
	
	@SuppressWarnings("unchecked")
	public List<Campo> list(){

		return (List<Campo>) listByQuery("SELECT c FROM Campo c ORDER BY c.nome");
	}
}
