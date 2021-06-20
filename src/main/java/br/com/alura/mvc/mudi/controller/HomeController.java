package br.com.alura.mvc.mudi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.mvc.mudi.model.Pedido;

@Controller
public class HomeController {
	
	@GetMapping("home")
	public String home(Model mv) {
		
		Pedido pedido = new Pedido();
		pedido.setNomeProduto("Yugioh! Card");
		pedido.setUrlImagem("https://awesomecardgames.com/wp-content/uploads/2019/10/Dark-Magician-Girl-Art-1.jpg");
		pedido.setUrlProduto("https://www.duelshop.com.br/yu-gi-oh/11153-borrelsword-dragon-cyho-en034-secret-rare.html");
		pedido.setDescricao("Descricao toper");
		
		List<Pedido> pedidos = Arrays.asList(pedido);
		mv.addAttribute("pedidos", pedidos);
		
		return "home";
	}

}
