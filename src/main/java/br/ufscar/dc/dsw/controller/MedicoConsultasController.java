package br.ufscar.dc.dsw.controller;


import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Consulta;
import br.ufscar.dc.dsw.domain.Medico;

import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.security.UsuarioDetails;

import br.ufscar.dc.dsw.service.spec.IMedicoService;
import br.ufscar.dc.dsw.service.spec.IConsultaService;


@Controller
@RequestMapping("/consultasmed")
public class MedicoConsultasController {
	
	@Autowired
	private IConsultaService consultaservice;
	
	@Autowired
	private IMedicoService medicoService;
	
	private Usuario getUsuario() {
		UsuarioDetails usuarioDetails = (UsuarioDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return usuarioDetails.getUsuario();
	}
	
	
	private Medico getMedico() {
		Usuario usuario = this.getUsuario();
		List<Medico> medicos = this.listaMedicos();
		Medico m = null;
		for(Medico medico : medicos) {
			if(medico.getUsername().equals(usuario.getUsername())) {
				m = medico;
			} 
		}
		return m;
	}
	
	@ModelAttribute("medicos")
	public List<Medico> listaMedicos() {
		return medicoService.buscarTodos();
	}
	
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
					
		model.addAttribute("consultas",consultaservice.buscarTodosByMed(this.getMedico()));
		
		return "compra/listaMed";
	}
}
