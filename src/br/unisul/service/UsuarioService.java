package br.unisul.service;

import java.util.Calendar;
import java.util.List;

import br.unisul.entity.Perfil;
import br.unisul.entity.Usuario;
import br.unisul.service.exception.ServiceException;
import br.unisul.util.EmailValidator;

public class UsuarioService extends BaseService {

    public void saveAdmin(Usuario usuario){
        
        if (usuario.getMail() == null || usuario.getMail().trim().equalsIgnoreCase("")) {

            throw new ServiceException("Informe o e-mail");
        }
        
        if(!EmailValidator.validate(usuario.getMail())){
            
            throw new ServiceException("E-mail inválido");
        }

        if (usuario.getSenha() == null || usuario.getSenha().trim().equalsIgnoreCase("")) {

            throw new ServiceException("Informe a senha");
        }

        if (usuario.getNome() == null || usuario.getNome().trim().equalsIgnoreCase("")) {

            throw new ServiceException("Informe o nome");
        }

        Usuario _usuario = (Usuario) oneByQuery("SELECT u FROM Usuario u WHERE u.mail = ?", usuario.getMail());

        if (_usuario != null) {

            throw new ServiceException("Este e-mail já esta em uso, escolha outro");
        }
        
        Perfil perfil = (Perfil) oneByQuery("SELECT p FROM Perfil p WHERE p.id = ?", usuario.getPerfil().getId());
        
        usuario.setPerfil(perfil);
        usuario.setDataCadastro(Calendar.getInstance());

        super.save(usuario);
    }
    
	public void save(Usuario usuario) throws ServiceException {

		if (usuario.getMail() == null || usuario.getMail().trim().equalsIgnoreCase("")) {

			throw new ServiceException("Informe o e-mail");
		}
		
		if(!EmailValidator.validate(usuario.getMail())){
			
			throw new ServiceException("E-mail inválido");
		}

		if (usuario.getSenha() == null || usuario.getSenha().trim().equalsIgnoreCase("")) {

			throw new ServiceException("Informe a senha");
		}

		if (usuario.getNome() == null || usuario.getNome().trim().equalsIgnoreCase("")) {

			throw new ServiceException("Informe o nome");
		}

		Usuario _usuario = (Usuario) oneByQuery("SELECT u FROM Usuario u WHERE u.mail = ?", usuario.getMail());

		if (_usuario != null) {

			throw new ServiceException("Este e-mail já esta em uso, escolha outro");
		}
		
		Perfil perfil = (Perfil) oneByQuery("SELECT p FROM Perfil p WHERE p.nome = ?", "CLIENTE");
		
		usuario.setPerfil(perfil);
		usuario.setDataCadastro(Calendar.getInstance());

		super.save(usuario);
	}
	
	public void edit(Long id, String senha, String nome, String telefone) {
		
		if (senha == null || senha.trim().equalsIgnoreCase("")) {

			throw new ServiceException("Informe a senha");
		}

		if (nome == null || nome.trim().equalsIgnoreCase("")) {

			throw new ServiceException("Informe o nome");
		}
		
		Usuario usuario = getEntityManager().find(Usuario.class, id);
		
		if(usuario == null){
			
			throw new ServiceException("Ocorreu um erro ao realizar a operação");
			
		}
		
		usuario.setSenha(senha);
		usuario.setNome(nome);
		usuario.setTelefone(telefone);
		
		super.update(usuario);
	}

	public void delete(Long idUsuario) throws ServiceException {

	}

	@SuppressWarnings("unchecked")
	public List<Usuario> list() {

		return (List<Usuario>) listByQuery("SELECT u FROM Usuario u ORDER BY u.mail");
	}

	public Usuario find(String mail, String password) {

		return (Usuario) oneByQuery("SELECT u FROM Usuario u WHERE u.mail = ? AND u.senha = ?", mail, password);
	}
	
	@SuppressWarnings("unchecked")
    public List<Perfil> listPerfis(){
	    
	    return (List<Perfil>) listByQuery("SELECT p FROM Perfil p");
	}
	
	public Perfil findPerfil(Long idPerfil){
	    
	    return getEntityManager().find(Perfil.class, idPerfil);
	}
}
