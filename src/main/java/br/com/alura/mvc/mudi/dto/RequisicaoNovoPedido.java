package br.com.alura.mvc.mudi.dto;

import br.com.alura.mvc.mudi.model.Pedido;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequisicaoNovoPedido {
	
	private String nomeProduto;
	private String urlProduto;
	private String urlImagem;
	private String descricao;
	
	
	public Pedido ToPedido() {
		
		Pedido pedido = new Pedido();
		pedido.setNomeProduto(nomeProduto);
		pedido.setUrlProduto(urlProduto);
		pedido.setUrlImagem(urlImagem);
		pedido.setDescricao(descricao);
		
		return pedido;
	}
}
