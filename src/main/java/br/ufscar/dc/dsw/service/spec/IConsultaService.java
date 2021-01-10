package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.Consulta;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.domain.Medico;
import br.ufscar.dc.dsw.domain.Paciente;

public interface IConsultaService {

	Consulta buscarPorId(Long id);
	
	List<Consulta> buscarTodos();

	List<Consulta> buscarTodosByPac(Paciente p);
	
	List<Consulta> buscarTodosByMed(Medico m);

	void salvar(Consulta editora);
}
