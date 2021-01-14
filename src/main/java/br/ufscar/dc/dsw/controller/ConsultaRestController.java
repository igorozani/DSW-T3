package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.ufscar.dc.dsw.domain.Consulta;
import br.ufscar.dc.dsw.domain.Medico;
import br.ufscar.dc.dsw.domain.Paciente;
import br.ufscar.dc.dsw.service.spec.IConsultaService;
import br.ufscar.dc.dsw.service.spec.IMedicoService;
import br.ufscar.dc.dsw.service.spec.IPacienteService;

@CrossOrigin
@RestController
public class ConsultaRestController {

	@Autowired
	private IConsultaService service;
	private IPacienteService servicePac;
	private IMedicoService serviceMed;

	private boolean isJSONValid(String jsonInString) {
		try {
			return new ObjectMapper().readTree(jsonInString) != null;
		} catch (IOException e) {
			return false;
		}
 }

	private void parse(Consulta consulta, JSONObject json) {
		
		Object id = json.get("id");
		if (id != null) {
			if (id instanceof Integer) {
				consulta.setId(((Integer) id).longValue());
			} else {
				consulta.setId((Long) id);
			}
 	}

		consulta.setPaciente((Paciente) json.get("paciente"));
		consulta.setMedico((Medico) json.get("medico"));
		consulta.setData((String) json.get("data"));
		consulta.setHora((String) json.get("hora"));
 }

	@GetMapping(path = "/consultas")
	public ResponseEntity<List<Consulta>> lista() {
		List<Consulta> lista = service.buscarTodos() ;
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
 }

	@GetMapping(path = "/consultas/{id}")
	public ResponseEntity<Consulta> lista(@PathVariable("id") long id) {
		Consulta consulta = service.buscarPorId(id);
		if (consulta == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(consulta);
 }

	@GetMapping(path = "/consultas/pacientes/{id}")
	public ResponseEntity<Consulta> lista(@PathVariable("id") Long id) {
		List<Consulta> consultas = service.buscarTodos();
		if(consultas == null) {
			return ResponseEntity.notFound().build();
		}
		for(Consulta consulta : consultas) {
			if(id == consulta.getPaciente().getId()) {
				return ResponseEntity.ok(consulta);
			}
		}		
		return ResponseEntity.notFound().build();	
 }
	
	@GetMapping(path = "/consultas/medicos/{id}")
	public ResponseEntity<Consulta> lista2(@PathVariable("id") Long id) {
		List<Consulta> consultas = service.buscarTodos();
		if(consultas == null) {
			return ResponseEntity.notFound().build();
		}
		for(Consulta consulta : consultas) {
			if(id == consulta.getMedico().getId()) {
				return ResponseEntity.ok(consulta);
			}
		}		
		return ResponseEntity.notFound().build();	
 }
	
}