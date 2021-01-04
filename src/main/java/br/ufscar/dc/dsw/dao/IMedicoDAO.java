package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import br.ufscar.dc.dsw.domain.Medico;

@SuppressWarnings("unchecked")
public interface IMedicoDAO extends CrudRepository<Medico, Long>{

	Medico findById(long id);

	List<Medico> findAll();
	
	Medico save(Medico medico);

	void deleteById(Long id);	
}