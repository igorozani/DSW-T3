package br.ufscar.dc.dsw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.dao.ICompraDAO;
import br.ufscar.dc.dsw.domain.Consulta;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.domain.Medico;
import br.ufscar.dc.dsw.domain.Paciente;
import br.ufscar.dc.dsw.service.spec.IConsultaService;

@Service
@Transactional(readOnly = false)
public class ConsultaService implements IConsultaService {

	@Autowired
	ICompraDAO dao;
	
	public void salvar(Consulta compra) {
		dao.save(compra);
	}

	@Transactional(readOnly = true)
	public Consulta buscarPorId(Long id) {
		return dao.findById(id.longValue());
	}

	@Transactional(readOnly = true)
	public List<Consulta> buscarTodos() {
		return (List<Consulta>) dao.findAll();
	}
	
	@Transactional(readOnly = true)
	public List<Consulta> buscarTodosByPac(Paciente p) {
		return dao.findAllByPaciente(p);
	}	
	
	@Transactional(readOnly = true)
	public List<Consulta> buscarTodosByMed(Medico m) {
		return dao.findAllByMedico(m);
	}
}
