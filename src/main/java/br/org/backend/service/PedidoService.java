package br.org.backend.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.org.backend.config.MailConfig;
import br.org.backend.dto.PedidoInserirDTO;
import br.org.backend.exception.ProductCodeException;
import br.org.backend.model.Pedido;
import br.org.backend.repository.PedidoRepository;

@Service
public class PedidoService 
{
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private MailConfig mailconfig;
	
	public List <PedidoInserirDTO> listar() 
	{
		
		List<Pedido> pedidos = pedidoRepository.findAll();

		return pedidos.stream().map(pe -> new PedidoInserirDTO(pe)).collect(Collectors.toList());
	}
	
	public PedidoInserirDTO inserir(PedidoInserirDTO pedidoInserirDTO) throws ProductCodeException {
			 
			if (pedidoRepository.findById(pedidoInserirDTO.getId()) != null) 
				throw new ProductCodeException("Pedido já existe ! Insira outro");
			else {
				Pedido pedido = new Pedido();
			
			pedido.setId_cliente(pedidoInserirDTO.getId_cliente());
			
		
			pedidoRepository.save(pedido);
			mailconfig.enviarEmail(pedidoInserirDTO.getId_cliente().getEmail(), "Pedido aberto", pedidoInserirDTO.toString());
			
			 return new PedidoInserirDTO(pedido);
		}
	}
		
	 public Pedido fecharPedido(Long id, float valor_total){
	    	
	    	if (!pedidoRepository.existsById (id)) 
	    		throw new ProductCodeException("Pedido não existe ! Insira outro");
	    	else {
	    		Pedido pedido = new Pedido();
	    		
	    		pedido.setId (id);
	    		
	    		pedido.setId(pedidoRepository.getById(id).getId());
	    	    pedido.setId_cliente(pedidoRepository.getById(id).getId_cliente());
	    		pedido.setStatus(true);
	    		pedido.setValorTotal(valor_total);
				pedido = pedidoRepository.save (pedido);
				mailconfig.enviarEmail(pedido.getId_cliente().getEmail(), "Pedido aberto", pedido.toString());

				return pedido;
	    	}
	    }
	 
	      public Pedido enviarPedido(Long id){
	    	
	    	if (!pedidoRepository.existsById (id)) 
	    		throw new ProductCodeException("Pedido não existe ! Insira outro");
	    	else {
	    		
	    		Pedido pedido = new Pedido();
	    		if(pedidoRepository.getById(id).isStatus() == true) 
	    		{
	    				
	    		   pedido.setId (id);
	    		
	    		   pedido.setId(pedidoRepository.getById(id).getId());
	    	       pedido.setId_cliente(pedidoRepository.getById(id).getId_cliente());
	    		
	    		   pedido.setValorTotal(pedidoRepository.getById(id).getValorTotal());
	    		
	    		
				   pedido = pedidoRepository.save (pedido);
				   mailconfig.enviarEmail(pedido.getId_cliente().getEmail(), "Pedido realizado!", pedido.toString());

				   return pedido;
	    		}
	    		else 
	    			throw new ProductCodeException("O pedido precisa ser finalizado!");
	    	}
	  }
}
