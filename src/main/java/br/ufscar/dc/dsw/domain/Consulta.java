package br.ufscar.dc.dsw.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Entity
@Table(name = "Consulta")
public class Consulta extends AbstractEntity<Long> {
    
	@NotNull(message = "{NotNull.compra.livro}")
	@ManyToOne
	@JoinColumn(name = "paciente_id")
	public Paciente paciente;
    
	/*@NotNull(message = "{NotNull.compra.livro}")
	@ManyToOne
	@JoinColumn(name = "livro_id")
	private Paciente livro;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;*/

	
	@NotNull(message = "{NotNull.compra.livro}")
	@ManyToOne
	@JoinColumn(name = "medico_id")
	private Medico medico;
	
	@NotBlank(message = "{NotNull.compra.livro}")
	@Column(nullable = false, length = 10)
	private String data;
	
	@NotBlank(message = "{NotNull.compra.livro}")
	@Column(nullable = false, length = 5)
	private String hora;

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
}
