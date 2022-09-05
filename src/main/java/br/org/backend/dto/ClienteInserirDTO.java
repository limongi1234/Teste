package br.org.backend.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.sun.istack.NotNull;
import br.org.backend.model.Pedido;


public class ClienteInserirDTO 
{
	
	@NotBlank(message = "O e-mail não pode ser nulo!")
	@Email(message = "email inválido!")
	@Size (max = 30, message = "O tamanho do campo email não pode ser superior a 30 caracteres!")
	private String email;
	
	@NotBlank(message = "O nome não pode ser nulo!")
	@Size (max = 50, message = "O tamanho do campo nome_usuario não pode ser superior a 20 caracteres!")
	private String nome_completo;
	
	@NotBlank(message = "O CPF não pode ser nulo!")
	@Size (max = 14, message = "O tamanho do campo senha não pode ser superior a 14 caracteres!")
	private String cpf;
	
	@NotNull
	private Pedido pedido;
	
	public ClienteInserirDTO(
			@NotBlank(message = "O e-mail não pode ser nulo!") @Email(message = "email inválido!") @Size(max = 30, message = "O tamanho do campo email não pode ser superior a 30 caracteres!") String email,
			@NotBlank(message = "O nome não pode ser nulo!") @Size(max = 50, message = "O tamanho do campo nome_usuario não pode ser superior a 20 caracteres!") String nome_completo,
			@NotBlank(message = "O CPF não pode ser nulo!") @Size(max = 14, message = "O tamanho do campo senha não pode ser superior a 14 caracteres!") String cpf,
			@NotBlank(message = "O endereço não pode ser nulo!") Pedido pedido)
	{
		super();
		this.email = email;
		this.nome_completo = nome_completo;
		this.cpf = cpf;
		this.pedido = pedido;
	}

    public ClienteInserirDTO()
    {
		super();
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getNome_completo() 
	{
		return nome_completo;
	}

	public void setNome_completo(String nome_completo) 
	{
		this.nome_completo = nome_completo;
	}

	public String getCpf()
	{
		return cpf;
	}

	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}

	public Pedido getPedido() 
	{
		return pedido;
	}

	public void setPedido(Pedido pedido)
	{
		this.pedido = pedido;
	}
}
