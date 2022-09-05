package br.org.backend.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Pedido")
public class Pedido 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Long id;
	
	@Column(name = "valorTotal")
	private double valorTotal;
	
	@ManyToOne
	@JoinColumn(name = "cliente_pedido")
	private Cliente id_cliente;
	
	@Column
	private boolean status = false;
	
	@Column(name = "sku")
	private String sku;
	
	@Column(name = "enderecoEntrega")
	private String  enderecoEntrega;
	
	@Column(name = "valorUnitario")
	private float valorUnitario;
	
	
	
	public Pedido() 
	{
		super();		
	}

    public Pedido(Long id, double valorTotal, Cliente id_cliente, boolean status, String sku, String enderecoEntrega,
			float valorUnitario) 
    {
		super();
		this.id = id;
		this.valorTotal = valorTotal;
		this.id_cliente = id_cliente;
		this.status = status;
		this.sku = sku;
		this.enderecoEntrega = enderecoEntrega;
		this.valorUnitario = valorUnitario;
	}

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public double getValorTotal() 
	{
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) 
	{
		this.valorTotal = valorTotal;
	}

	public Cliente getId_cliente() 
	{
		return id_cliente;
	}

	public void setId_cliente(Cliente id_cliente) 
	{
		this.id_cliente = id_cliente;
	}

	public boolean isStatus() 
	{
		return status;
	}

	public void setStatus(boolean status) 
	{
		this.status = status;
	}

	public String getSku() 
	{
		return sku;
	}

	public void setSku(String sku)
	{
		this.sku = sku;
	}

	public String getEnderecoEntrega() 
	{
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(String enderecoEntrega)
	{
		this.enderecoEntrega = enderecoEntrega;
	}

	public float getValorUnitario() 
	{
		return valorUnitario;
	}

	public void setValorUnitario(float valorUnitario)
	{
		this.valorUnitario = valorUnitario;
	}

	@Override
	public String toString()
	{
		return "Pedido [id = " + id + ", valorTotal = " + valorTotal + ", id_cliente = " + id_cliente + ", status = " + status
				+ ", sku = " + sku + ", enderecoEntrega = " + enderecoEntrega + ", valorUnitario = " + valorUnitario + "]";
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}
}