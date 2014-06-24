package br.unisul.service;

import br.unisul.entity.Perfil;
import br.unisul.service.exception.ServiceException;

public class PerfilService extends BaseService {

    public void save(Perfil perfil) throws ServiceException {

        if (perfil.getNome() == null || perfil.getNome().trim().equalsIgnoreCase("")) {

            throw new ServiceException("Informe o nome");
        }

        super.save(perfil);
    }

}
