package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.domain.Consulta;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.domain.Medico;

@SuppressWarnings("unchecked")
public interface ICompraDAO extends CrudRepository<Consulta, Long>{

	Consulta findById(long id);

	List<Consulta> findAllByUsuario(Usuario u);
	
	List<Consulta> findAllByMedico(Medico m);
	
	Consulta save(Consulta compra);
}