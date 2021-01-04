package br.ufscar.dc.dsw.controller;

import java.util.List;

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


import br.ufscar.dc.dsw.domain.Paciente;
import br.ufscar.dc.dsw.service.spec.IMedicoService;
import br.ufscar.dc.dsw.service.spec.IPacienteService;

@Controller
@RequestMapping("/pacientes")
public class PacientesAdmController {

	@Autowired
	private IPacienteService pacienteService;

	@Autowired
	private IMedicoService medicoService;

	@GetMapping("/cadastrar")
	public String cadastrar(Paciente paciente) {
		return "paciente/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pacientes",pacienteService.buscarTodos());
		return "paciente/lista";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Paciente paciente, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "paciente/cadastro";
		}

		pacienteService.salvar(paciente);
		attr.addFlashAttribute("sucess", "Paciente inserido com sucesso");
		return "redirect:/pacientes/listar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("paciente", pacienteService.buscarPorId(id));
		return "paciente/cadastro";
	}

	@PostMapping("/editar")
	public String editar(@Valid Paciente paciente, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "paciente/cadastro";
		}

		pacienteService.salvar(paciente);
		attr.addFlashAttribute("sucess", "Paciente editado com sucesso.");
		return "redirect:/pacientes/listar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		pacienteService.excluir(id);
		attr.addFlashAttribute("sucess", "Paciente excluído com sucesso.");
		return "redirect:/pacientes/listar";
	}

	//@ModelAttribute("editoras")
	//public List<Editora> listaEditoras() {
	//	return editoraService.buscarTodos();
	//}
}
