package artboxproject.artboxproject.services;

import artboxproject.artboxproject.models.Cliente;
import artboxproject.artboxproject.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    //Criar um novo usuário (cliente)
    public Cliente createCliente(Cliente cliente) {
        //Verificação se cpf e email já existem no banco de dados
        if (clienteRepository.findByEmail(cliente.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Este email já está cadastrado.");
        }
        if (clienteRepository.findByCpf(cliente.getCpf()).isPresent()) {
            throw new IllegalArgumentException("Este CPF já está cadastrado.");
        }

        return clienteRepository.save(cliente);
    }

    //Buscar todos os clientes
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    //Buscar cliente por id
    public Optional<Cliente> getClienteById(Long id) {
        return clienteRepository.findById(id);
    }

    //Atualizar um cliente
    public Cliente updateCliente(Long id, Cliente clienteDetails) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cliente Não foi encontrado."));

        cliente.setNome(clienteDetails.getNome());
        cliente.setEmail(clienteDetails.getEmail());
        cliente.setCpf(clienteDetails.getCpf());

        return clienteRepository.save(cliente);
    }


    //Deletar um cliente por ID
    public void deleteCliente(long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cliente Não foi encontrado."));
        clienteRepository.delete(cliente);
    }

}