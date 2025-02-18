package artboxproject.artboxproject.controllers;

import artboxproject.artboxproject.models.HistoricoCompras;
import artboxproject.artboxproject.services.HistoricoComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/compras")
public class HistoricoComprasController {

    @Autowired
    private HistoricoComprasService historicoComprasService;

    // Criar uma nova compra
    @PostMapping
    public HistoricoCompras createCompra(@RequestBody HistoricoCompras compra) {
        return historicoComprasService.createCompra(compra);
    }

    // Buscar todas as compras
    @GetMapping
    public List<HistoricoCompras> getAllCompras() {
        return historicoComprasService.getAllCompras();
    }

    // Buscar compras por id de cliente
    @GetMapping("/cliente/{clienteId}")
    public List<HistoricoCompras> getComprasByClienteId(@PathVariable Long clienteId) {
        return historicoComprasService.getComprasByClienteId(clienteId);
    }

    // Buscar uma compra específica pelo id de compra
    @GetMapping("/{id}")
    public Optional<HistoricoCompras> getCompraById(@PathVariable Long id) {
        return historicoComprasService.getCompraById(id);
    }
}
