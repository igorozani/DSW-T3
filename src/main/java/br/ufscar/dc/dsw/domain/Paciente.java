package br.ufscar.dc.dsw.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "Paciente")
@PrimaryKeyJoinColumn(name="id")
public class Paciente extends Usuario {

	@NotBlank(message = "{NotBlank.paciente.nome}")
	@Size(max = 60)
	@Column(nullable = false, length = 60)
	private String nome;

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
