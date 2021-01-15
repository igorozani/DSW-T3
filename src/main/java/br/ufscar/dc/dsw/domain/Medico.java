	package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@SuppressWarnings("serial")
@Entity
@Table(name = "Medico")
@PrimaryKeyJoinColumn(name="id")
public class Medico extends Usuario {
 
    @NotBlank
    @Column(nullable = false, length = 60)
    private String nome;
    
    @NotBlank
    @Column(nullable = false, length = 20)
    private String Especialidade;
    
    @NotBlank
    @Column(nullable = false, length = 20)
    private String crm;
    
    @Column(nullable = false)
    private boolean enabled;		
	
	public String getName() {
		return nome;
	}
	
	public void setName(String nome) {
		this.nome = nome;
	}
	
	
	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}
	
	public String getEspecialidade() {
		return Especialidade;
	}
	
	public void setEspecialidade(String especialidade) {
		this.Especialidade = especialidade;
	}
	
}