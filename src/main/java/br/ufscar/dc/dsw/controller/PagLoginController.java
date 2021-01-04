package br.ufscar.dc.dsw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufscar.dc.dsw.service.spec.IMedicoService;

@Controller
@RequestMapping("/login")
public class PagLoginController {

	@Autowired
	private IMedicoService service;
	
	@GetMapping("")
	public String listar(ModelMap model) {
		model.addAttribute("medicos",service.buscarTodos());
		return "login";
	}
}
