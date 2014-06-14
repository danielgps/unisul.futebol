package br.unisul.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.unisul.entity.enun.TipoPerfil;

@Entity
@Table(name = "usr__usuario")
public class Usuario implements BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String telefone;

	private String mail;

	private String login;

	private String senha;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro")
	private Calendar dataCadastro;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_perfil")
	private TipoPerfil tipoPerfil;

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public String getNome() {

		return nome;
	}

	public void setNome(String nome) {

		this.nome = nome;
	}

	public String getTelefone() {

		return telefone;
	}

	public void setTelefone(String telefone) {

		this.telefone = telefone;
	}

	public String getMail() {

		return mail;
	}

	public void setMail(String mail) {

		this.mail = mail;
	}

	public String getLogin() {

		return login;
	}

	public void setLogin(String login) {

		this.login = login;
	}

	public String getSenha() {

		return senha;
	}

	public void setSenha(String senha) {

		this.senha = senha;
	}

	public Calendar getDataCadastro() {

		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {

		this.dataCadastro = dataCadastro;
	}

	public TipoPerfil getTipoPerfil() {

		return tipoPerfil;
	}

	public void setTipoPerfil(TipoPerfil tipoPerfil) {

		this.tipoPerfil = tipoPerfil;
	}
}
