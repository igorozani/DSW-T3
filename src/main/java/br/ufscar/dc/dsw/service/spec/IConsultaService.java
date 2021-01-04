package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.Consulta;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.domain.Medico;

public interface IConsultaService {

	Consulta buscarPorId(Long id);

	List<Consulta> buscarTodos(Usuario u);
	
	List<Consulta> buscarTodosByMed(Medico m);

	void salvar(Consulta editora);
}
