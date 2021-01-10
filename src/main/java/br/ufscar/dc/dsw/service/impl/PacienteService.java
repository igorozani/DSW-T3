package br.ufscar.dc.dsw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import br.ufscar.dc.dsw.dao.IPacienteDAO;
import br.ufscar.dc.dsw.dao.IUsuarioDAO;
import br.ufscar.dc.dsw.domain.Paciente;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.service.spec.IPacienteService;

@Service
@Transactional(readOnly = false)
public class PacienteService implements IPacienteService {

	@Autowired
	IPacienteDAO pacientedao;
	
	public void salvar(Paciente paciente) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();		
		paciente.setPassword(encoder.encode(paciente.getPassword()));
		pacientedao.save(paciente);	
	}

	public void excluir(Long id) {
		pacientedao.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Paciente buscarPorId(Long id) {
		return pacientedao.findById(id.longValue());
	}

	@Transactional(readOnly = true)
	public List<Paciente> buscarTodos() {
		return pacientedao.findAll();
	}
}
