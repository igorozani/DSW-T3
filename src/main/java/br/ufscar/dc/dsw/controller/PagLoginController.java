package br.ufscar.dc.dsw.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufscar.dc.dsw.domain.Medico;

import br.ufscar.dc.dsw.service.spec.IMedicoService;

@Controller
@RequestMapping("/login")
public class PagLoginController {

	@Autowired
	private IMedicoService service;
	
	@GetMapping("")
	public String listar(ModelMap model) {
		List<Medico> medicos = service.buscarTodos();
		ArrayList<String> especialidades = new ArrayList();		
		for(Medico medico : medicos) {
			if(!especialidades.contains(medico.getEspecialidade())) {
				especialidades.add(medico.getEspecialidade());
			}
		}
		model.addAttribute("medicos",service.buscarTodos());
		model.addAttribute("especialidades",especialidades);
		return "login";
	}
	
	@PostMapping("/especialidade")
	public String filtrar(@ModelAttribute("especialidade") String especialidade, 
			ModelMap model) {
		List<Medico> medicos = service.buscarTodos();
		ArrayList<String> especialidades = new ArrayList();		
		for(Medico medico : medicos) {
			if(!especialidades.contains(medico.getEspecialidade())) {
				especialidades.add(medico.getEspecialidade());
			}
		}
		List<Medico> filteredList = new ArrayList<>();
		for (Medico medico: medicos) {
            if (medico.getEspecialidade().equals(especialidade)) {
                filteredList.add(medico);
            }	        
	    }
		model.addAttribute("medicos",filteredList);
		model.addAttribute("especialidades",especialidades);
		return "login";
	}
}
