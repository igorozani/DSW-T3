	package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@SuppressWarnings("serial")
@Entity
@Table(name = "Medico")
public class Medico extends AbstractEntity<Long> {
  
	@NotBlank
    @Column(nullable = false, length = 20, unique = true)
    private String username;
    
	@NotBlank
    @Column(nullable = false, length = 64)
    private String password;
       
    @NotBlank
    @Column(nullable = false, length = 60, unique = true)
    private String name;
    
    @NotBlank
    @Column(nullable = false, length = 20)
    private String Especialidade;
    
    @NotBlank
    @Column(nullable = false, length = 20)
    private String crm;
    
    @Column(nullable = false)
    private boolean enabled;
		
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}