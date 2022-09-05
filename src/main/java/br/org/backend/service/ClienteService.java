package br.org.backend.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import br.org.backend.config.MailConfig;
import br.org.backend.dto.ClienteDTO;
import br.org.backend.dto.ClienteInserirDTO;
import br.org.backend.exception.EmailException;
import br.org.backend.model.Cliente;
import br.org.backend.repository.ClienteRepository;

@Service
public class ClienteService 
{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private MailConfig mailconfig;
	
	@Autowired 
	private PedidoService pedidoService;
	
	public List <ClienteDTO> listar()
	{
		
		List <Cliente> clientes = clienteRepository.findAll();
		
		return clientes.stream().map(c -> new ClienteDTO(c)).collect(Collectors.toList());
	}
	
	public ClienteDTO inserir(ClienteInserirDTO clienteInserirDTO) throws EmailException
	{

		if (clienteRepository.findByEmail(clienteInserirDTO.getEmail()) != null) 
			throw new EmailException("Email já existe ! Insira outro");
		clienteInserirDTO.setCpf(bCryptPasswordEncoder.encode(clienteInserirDTO.getCpf()));
		
		Cliente cliente = new Cliente(clienteInserirDTO);
		
		clienteRepository.save(cliente);
		mailconfig.enviarEmail(cliente.getEmail(), "Cadastro de Cliente Confirmado", cliente.toString());
		 return new ClienteDTO(cliente);
	}
}
