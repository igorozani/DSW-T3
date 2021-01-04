package br.ufscar.dc.dsw.domain;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "Paciente")
public class Paciente extends AbstractEntity<Long> {

	@NotBlank(message = "{NotBlank.paciente.nome}")
	@Size(max = 60)
	@Column(nullable = false, length = 60)
	private String nome;

	@NotBlank(message = "{NotBlank.paciente.login}")
	@Size(max = 60)
	@Column(nullable = false, length = 20)
	private String login;
    
	@NotBlank(message = "{NotBlank.paciente.senha}")
	@Column(nullable = false, length = 20)
	private String senha;
	
	@NotBlank(message = "{NotBlank.paciente.cpf}")
	@Column(nullable = false, length = 20)
	private String cpf;
    
	

	@NotBlank(message = "{NotBlank.paciente.telefone}")
	@Column(nullable = false, length = 20)
	private String telefone;
	
	@NotBlank(message = "{NotBlank.paciente.sexo}")
	@Column(nullable = false, length = 20)
	private String sexo;
	
	@NotBlank(message = "{NotBlank.paciente.nascimento}")
	@Column(nullable = false, length = 20)
	private String nascimento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getPreco() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
}
