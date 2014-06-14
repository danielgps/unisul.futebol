package br.unisul.service;

import java.util.Calendar;
import java.util.List;

import br.unisul.entity.Usuario;
import br.unisul.entity.enun.TipoPerfil;
import br.unisul.service.exception.ServiceException;

public class UsuarioService extends BaseService {

	public void save(Usuario usuario) throws ServiceException {
		
		if(usuario.getLogin() == null || usuario.getLogin().trim().equalsIgnoreCase("")){
			
			throw new ServiceException("Informe o login");
		}
		
		if(usuario.getSenha() == null || usuario.getSenha().trim().equalsIgnoreCase("")){
			
			throw new ServiceException("Informe a senha");
		}
		
		if(usuario.getNome() == null || usuario.getNome().trim().equalsIgnoreCase("")){
			
			throw new ServiceException("Informe o nome");
		}
		
		Usuario _usuario = (Usuario) oneByQuery("SELECT u FROM Usuario u WHERE u.login = ?", usuario.getLogin());
		
		if(_usuario != null){
			
			throw new ServiceException("Este login já esta em uso, escolha outro");
		}
		
		usuario.setTipoPerfil(TipoPerfil.CLIENTE);
		usuario.setDataCadastro(Calendar.getInstance());
		
		super.save(usuario);
	}

	public void edit(Usuario usuario) throws ServiceException {

	}

	public void delete(Long idUsuario) throws ServiceException {

	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> list(){
		
		return (List<Usuario>) listByQuery("SELECT u FROM Usuario u ORDER BY u.login");
	}
}
