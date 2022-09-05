package br.org.backend.dto;

import br.org.backend.model.Cliente;

public class ClienteDTO 
{
	
	private Long id;
	private String nome_completo, email;
	
	public ClienteDTO(Cliente c) 
	{
		super();
	}

	public ClienteDTO(Long id, String nome_completo, String email) 
	{
		super();
		this.id = id;
		this.nome_completo = nome_completo;
		this.email = email;
	}

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getNome_completo() 
	{
		return nome_completo;
	}

	public void setNome_completo(String nome_completo) 
	{
		this.nome_completo = nome_completo;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}
}
