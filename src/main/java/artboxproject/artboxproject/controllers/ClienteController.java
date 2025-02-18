package artboxproject.artboxproject.controllers;

import artboxproject.artboxproject.models.Cliente;
import artboxproject.artboxproject.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {


    @Autowired
    private ClienteService clienteService;


    //Metodo para criar um novo cliente
    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente novoCliente = clienteService.createCliente(cliente);
        return ResponseEntity.ok(novoCliente);
    }


    //Metodo para buscar todos os clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> clientes = clienteService.getAllClientes();
        return ResponseEntity.ok(clientes);
    }


    //Metodo par abuscar cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.getClienteById(id);
        return cliente.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    //Metodo para atualizar cliente por ID
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente clienteDetails) {
        Cliente clienteAtualizado = clienteService.updateCliente(id, clienteDetails);
        return ResponseEntity.noContent().build();
    }


    //Metodo para deletar cliente por ID
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }


    //Teste para verificar se a aplicação esta rodando corretamente.
    @GetMapping("/teste")
    public String teste() {
        return "Aplicação rodando!";
    }
}
