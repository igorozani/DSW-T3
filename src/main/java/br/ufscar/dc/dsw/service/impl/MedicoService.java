package br.ufscar.dc.dsw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.dao.IMedicoDAO;
import br.ufscar.dc.dsw.dao.IUsuarioDAO;
import br.ufscar.dc.dsw.domain.Medico;
import br.ufscar.dc.dsw.domain.Paciente;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.service.spec.IMedicoService;

@Service
@Transactional(readOnly = false)
public class MedicoService implements IMedicoService {

	@Autowired
	IMedicoDAO medicodao;
	@Autowired
	IUsuarioDAO usuariodao;
	
	
	
	public void salvar(Medico medico) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Medico novomedico = new Medico();
		novomedico.setCrm(medico.getCrm());
		novomedico.setEspecialidade(medico.getEspecialidade());
		novomedico.setName(medico.getName());
		novomedico.setEnabled(true);
		novomedico.setUsername(medico.getUsername());				
		novomedico.setPassword(encoder.encode(medico.getPassword()));
		novomedico.setRole(medico.getRole());
		medicodao.save(novomedico);			
	}

	public void excluir(Long id) {
		medicodao.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Medico buscarPorId(Long id) {
		return medicodao.findById(id.longValue());
	}

	@Transactional(readOnly = true)
	public List<Medico> buscarTodos() {
		return medicodao.findAll();
	}
	
	
}
