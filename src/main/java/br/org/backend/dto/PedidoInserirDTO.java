package br.org.backend.dto;

import java.time.LocalDate;

import br.org.backend.model.Cliente;
import br.org.backend.model.Pedido;

public class PedidoInserirDTO 
{
	private Long id;
	private String sku;
	private Cliente id_cliente;
	
	public PedidoInserirDTO(Long id, String sku, Cliente id_cliente) 
	{
		super();
		this.id = id;
		this.sku = sku;
		this.id_cliente = id_cliente;
	}

	public PedidoInserirDTO()
	{
		super();
	}
	
	public PedidoInserirDTO(Pedido pedido) 
	{
		super();
		this.id = pedido.getId();
		this.sku = pedido.getSku();
		this.id_cliente = pedido.getId_cliente();
	}

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getSku()
	{
		return sku;
	}

	public void setSku(String sku) 
	{
		this.sku = sku;
	}

	public Cliente getId_cliente() 
	{
		return id_cliente;
	}

	public void setId_cliente(Cliente id_cliente) 
	{
		this.id_cliente = id_cliente;
	}

	@Override
	public String toString()
	{
		return "PedidoInserirDTO [id = " + id + ", sku = " + sku + ", id_cliente = " + id_cliente + "]";
	}
}
