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
	IPacienteDAO dao;
	@Autowired
	IUsuarioDAO usuariodao;
	
	
	public void salvar(Paciente paciente) {
		dao.save(paciente);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Usuario usuario = new Usuario();
		usuario.setUsername(paciente.getLogin());
		usuario.setPassword((encoder.encode(paciente.getSenha())));
		usuario.setName(paciente.getNome());
		usuario.setRole("ROLE_PA");
		usuario.setEnabled(true);
		usuariodao.save(usuario);
	}

	public void excluir(Long id) {
		dao.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Paciente buscarPorId(Long id) {
		return dao.findById(id.longValue());
	}

	@Transactional(readOnly = true)
	public List<Paciente> buscarTodos() {
		return dao.findAll();
	}
}
