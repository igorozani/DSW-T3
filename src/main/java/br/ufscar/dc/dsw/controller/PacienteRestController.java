package br.ufscar.dc.dsw.controller;

import java.io.IOException;
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
import br.ufscar.dc.dsw.domain.Paciente;
import br.ufscar.dc.dsw.service.spec.IPacienteService;

@CrossOrigin
@RestController
public class PacienteRestController {

	@Autowired
 private IPacienteService service;

	private boolean isJSONValid(String jsonInString) {
		try {
			return new ObjectMapper().readTree(jsonInString) != null;
		} catch (IOException e) {
			return false;
		}
 }

	private void parse(Paciente paciente, JSONObject json) {
		
		Object id = json.get("id");
		if (id != null) {
			if (id instanceof Integer) {
				paciente.setId(((Integer) id).longValue());
			} else {
				paciente.setId((Long) id);
			}
 	}

		paciente.setNome((String) json.get("nome"));
		paciente.setCpf((String) json.get("cpf"));
		paciente.setEnabled((Boolean) json.get("enabled"));
		paciente.setNascimento((String) json.get("nascimento"));
		paciente.setPassword((String) json.get("password"));
		paciente.setRole((String) json.get("role"));
		paciente.setSexo((String) json.get("sexo"));
		paciente.setTelefone((String) json.get("telefone"));
		paciente.setUsername((String) json.get("username"));
 }

	@GetMapping(path = "/pacientes")
	public ResponseEntity<List<Paciente>> lista() {
		List<Paciente> lista = service.buscarTodos() ;
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
 }

	@GetMapping(path = "/pacientes/{id}")
	public ResponseEntity<Paciente> lista(@PathVariable("id") long id) {
		Paciente paciente = service.buscarPorId(id);
		if (paciente == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(paciente);
 }

	@PostMapping(path = "/pacientes")
	@ResponseBody
	public ResponseEntity<Paciente> cria(@RequestBody JSONObject json) {
		try {
			if (isJSONValid(json.toString())) {
				Paciente paciente = new Paciente();
				parse(paciente, json);
				service.salvar(paciente);
				return ResponseEntity.ok(paciente);
			} else {
				return ResponseEntity.badRequest().body(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
		}
 }

	@PutMapping(path = "/pacientes/{id}")
	public ResponseEntity<Paciente> atualiza(@PathVariable("id") long id, @RequestBody JSONObject json) {
		try {
			if (isJSONValid(json.toString())) {
				Paciente paciente = service.buscarPorId(id);
				if (paciente == null) {
					return ResponseEntity.notFound().build();
				} else {
					parse(paciente, json);
					service.salvar(paciente);
					return ResponseEntity.ok(paciente);
				}
			} else {
				return ResponseEntity.badRequest().body(null);
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
		}
 }

	@DeleteMapping(path = "/pacientes/{id}")
 public ResponseEntity<Boolean> remove(@PathVariable("id") long id) {

		Paciente paciente = service.buscarPorId(id);
		if (paciente == null) {
			return ResponseEntity.notFound().build();
		} else {
			service.excluir(id);
			return ResponseEntity.noContent().build();
		}
	}
}