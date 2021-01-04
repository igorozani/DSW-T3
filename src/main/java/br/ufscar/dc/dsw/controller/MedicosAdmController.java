package br.ufscar.dc.dsw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.dao.IUsuarioDAO;
import br.ufscar.dc.dsw.domain.Medico;
import br.ufscar.dc.dsw.service.spec.IMedicoService;




@Controller
@RequestMapping("/medicos")
public class MedicosAdmController {
	
	@Autowired
	private IMedicoService service;
	
	
	@GetMapping("/cadastrar")
	public String cadastrar(Medico medico) {
		return "medico/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("medicos",service.buscarTodos());
		return "medico/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Medico medico, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "medico/cadastro";
		}
		
		service.salvar(medico);
		attr.addFlashAttribute("sucess", "Medico inserido com sucesso.");
		return "redirect:/medicos/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("medico", service.buscarPorId(id));
		return "medico/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Medico medico, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "medico/cadastro";
		}

		service.salvar(medico);
		attr.addFlashAttribute("sucess", "Medico editado com sucesso.");
		return "redirect:/medicos/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		
			service.excluir(id);
			model.addAttribute("sucess", "Medico excluido com sucesso.");
		
		return listar(model);
	}
}
