package br.ufscar.dc.dsw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.dao.IMedicoDAO;
import br.ufscar.dc.dsw.dao.IUsuarioDAO;
import br.ufscar.dc.dsw.domain.Medico;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.service.spec.IMedicoService;

@Service
@Transactional(readOnly = false)
public class MedicoService implements IMedicoService {

	@Autowired
	IMedicoDAO dao;
	@Autowired
	IUsuarioDAO usuariodao;
	
	
	
	public void salvar(Medico medico) {
		dao.save(medico);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Usuario usuario = new Usuario();
		usuario.setUsername(medico.getUsername());
		usuario.setPassword(encoder.encode(medico.getPassword()));
		usuario.setName(medico.getName());
		usuario.setRole("ROLE_ME");
		usuario.setEnabled(true);
		usuariodao.save(usuario);
	}

	public void excluir(Long id) {
		dao.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Medico buscarPorId(Long id) {
		return dao.findById(id.longValue());
	}

	@Transactional(readOnly = true)
	public List<Medico> buscarTodos() {
		return dao.findAll();
	}
	
	
}
