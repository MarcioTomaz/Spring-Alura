package br.com.alura.mvc.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private PedidoRepository PedidoRepository;	

	@GetMapping
	public String home(Model mv, Principal principal) {
		
		List<Pedido> pedidos = PedidoRepository.findAllByUsuario(principal.getName());
		mv.addAttribute("pedidos", pedidos);
		
		return "home";
	}
	
	@GetMapping("/{status}")
	public String porStatus(@PathVariable("status") String status, Model mv) {
		
		List<Pedido> pedidos = PedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
		mv.addAttribute("pedidos", pedidos);
		mv.addAttribute("status", status);
		
		return "home";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}

}
