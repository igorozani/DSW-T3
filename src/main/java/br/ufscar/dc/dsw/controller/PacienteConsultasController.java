package br.ufscar.dc.dsw.controller;


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
@RequestMapping("/consultaspa")
public class PacienteConsultasController {
	
	@Autowired
	private IConsultaService consultaservice;
	
	@Autowired
	private IMedicoService medicoService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Consulta consulta) {
		consulta.setUsuario(this.getUsuario());
		
		//compra.setValor(compra.getLivro().getPreco());
		return "compra/cadastro";
	}
	
	private Usuario getUsuario() {
		UsuarioDetails usuarioDetails = (UsuarioDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return usuarioDetails.getUsuario();
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
					
		model.addAttribute("consultas",consultaservice.buscarTodos(this.getUsuario()));
		
		return "compra/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Consulta consulta, BindingResult result, RedirectAttributes attr) {
		
		//String data = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
		consulta.setUsuario(this.getUsuario());
		
		//compra.setValor(compra.getLivro().getPreco());
		
		consultaservice.salvar(consulta);
		attr.addFlashAttribute("sucess", "Consulta cadastrada com sucesso.");
		return "redirect:/consultaspa/listar";
	}
	
	@ModelAttribute("medicos")
	public List<Medico> listaMedicos() {
		return medicoService.buscarTodos();
	}
}
