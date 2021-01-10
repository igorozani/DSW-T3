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
import br.ufscar.dc.dsw.domain.Paciente;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.security.UsuarioDetails;

import br.ufscar.dc.dsw.service.spec.IMedicoService;
import br.ufscar.dc.dsw.service.spec.IPacienteService;
import br.ufscar.dc.dsw.service.spec.IConsultaService;


@Controller
@RequestMapping("/consultaspa")
public class PacienteConsultasController {
	
	@Autowired
	private IConsultaService consultaservice;
	
	@Autowired
	private IMedicoService medicoService;
	
	@Autowired
	private IPacienteService pacienteService;
	
	
	@GetMapping("/cadastrar")
	public String cadastrar(Consulta consulta) {
		consulta.setPaciente(this.getPaciente());
		
		//compra.setValor(compra.getLivro().getPreco());
		return "compra/cadastro";
	}
	
	private Paciente getPaciente() {
		UsuarioDetails usuarioDetails = (UsuarioDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Usuario usuario = usuarioDetails.getUsuario();
		Paciente paciente = pacienteService.buscarPorId(usuario.getId());
		return paciente;
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
					
		model.addAttribute("consultas",consultaservice.buscarTodosByPac(this.getPaciente()));
		
		return "compra/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Consulta consulta, BindingResult result, RedirectAttributes attr) {
		
		//String data = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
		consulta.setPaciente(this.getPaciente());
		
		//compra.setValor(compra.getLivro().getPreco());
		List<Consulta> consultas = consultaservice.buscarTodos();
		// flag para saber se encontrou uma consulta na mesma data e hora 
//		boolean flag = false;
		for(Consulta consulta1 : consultas) {
			// pego as consultas do mesmo medico
			if(consulta.getMedico().equals(consulta1.getMedico())) {
				// pego as consultas da mesma data
				if(consulta.getData().equals(consulta1.getData())) {
					// pego as consultas na mesma hora
					if(consulta1.getHora().equals(consulta.getHora())) {
						// se entrar aqui é pq ta batendo o horario
//						flag = true;
						attr.addFlashAttribute("fail", "O médico selecionado já possui uma consulta neste horário.");
						return "redirect:/consultaspa/cadastrar";
					}
				}
			}
			if(consulta.getPaciente().equals(consulta1.getPaciente())) {
				// pego as consultas da mesma data
				if(consulta.getData().equals(consulta1.getData())) {
					// pego as consultas na mesma hora
					if(consulta1.getHora().equals(consulta.getHora())) {
						// se entrar aqui é pq ta batendo o horario
//						flag = true;
						attr.addFlashAttribute("fail", "Você já tem uma consulta agendada neste horário.");
						return "redirect:/consultaspa/cadastrar";
					}
				}
			}
		}		
			consultaservice.salvar(consulta);
			attr.addFlashAttribute("sucess", "Consulta cadastrada com sucesso.");
			return "redirect:/consultaspa/listar";			
		
	}
	
	@ModelAttribute("medicos")
	public List<Medico> listaMedicos() {
		return medicoService.buscarTodos();
	}
}
