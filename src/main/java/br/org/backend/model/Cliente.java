package br.org.backend.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import br.org.backend.dto.ClienteInserirDTO;


@Entity
public class Cliente 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long id;
	
	@Email(message = "email inválido!")
	@Size (max = 30, message = "O tamanho do campo email não pode ser superior a 30 caracteres!")
	@Column(length = 30, nullable = false)
	private String email;
	
	@Size (max = 60, message = "O tamanho do campo nome_completo não pode ser superior a 60 caracteres!")
	@Column(length = 60, nullable = false)
	private String nome_completo;
	
    @CPF(message = "CPF inválido!")
	@Size (max = 14, message = "O campo CPF deve conter 14 caracteres!")
	@Column(length = 14)
	private String cpf;
	
    @Size (max = 60, message = "O campo endereço não pode ser superior a 60 caracteres!")
	@Column
	private String endereco;
	
	@Size (max = 11, message = "Informe o número de telefone com  DDD!")
	@Column(length = 11, nullable = false)
	private String telefone;
	
	@Future(message = "Data Inválida!")
	@Column(name = "data_nasc")
	private LocalDate dataNascimento;
	
	@ManyToOne
	@JoinColumn(name = "cep")
	private Pedido pedido;
	
	public Cliente() 
	{
		super();
	}

	public Cliente(Long id,
			@Email(message = "email inválido!") @Size(max = 30, message = "O tamanho do campo email não pode ser superior a 30 caracteres!") String email,
			@Size(max = 60, message = "O tamanho do campo nome_completo não pode ser superior a 60 caracteres!") String nome_completo,
			@CPF(message = "CPF inválido!") @Size(max = 14, message = "O campo CPF deve conter 14 caracteres!") String cpf,
			@Size(max = 60, message = "O campo endereço não pode ser superior a 60 caracteres!") String endereco,
			@Size(max = 11, message = "Informe o número de telefone com  DDD!") String telefone,
			@Future(message = "Data Inválida!") LocalDate dataNascimento, Pedido pedido) 
    {
		super();
		this.id = id;
		this.email = email;
		this.nome_completo = nome_completo;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.pedido = pedido;
	}

    public Cliente(ClienteInserirDTO clienteInserirDTO) 
	{
		this.email = clienteInserirDTO.getEmail();
		this.nome_completo = clienteInserirDTO.getNome_completo();
		this.cpf = clienteInserirDTO.getCpf();
		this.pedido = clienteInserirDTO.getPedido();
	}

    public Long getId() 
    {
		return id;
	}

    public void setId(Long id) 
    {
		this.id = id;
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

    public String getEndereco() 
    {
		return endereco;
	}

    public void setEndereco(String endereco) 
	{
		this.endereco = endereco;
	}

    public String getTelefone() 
    {
		return telefone;
	}

    public void setTelefone(String telefone) 
    {
		this.telefone = telefone;
	}

    public LocalDate getDataNascimento() 
    {
		return dataNascimento;
	}

    public void setDataNascimento(LocalDate dataNascimento) 
    {
		this.dataNascimento = dataNascimento;
	}

    public Pedido getPedido() 
    {
		return pedido;
	}

    public void setPedido(Pedido pedido) 
    {
		this.pedido = pedido;
	}

    @Override
	public String toString() 
	{
		return "Cliente [id = " + id + ", email = " + email + ", nome_completo = " + nome_completo + ", cpf = " + cpf
				+ ", endereco = " + endereco + ", telefone = " + telefone + ", dataNascimento = " + dataNascimento
				+ ", pedido = " + pedido + "]";
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
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}
}
