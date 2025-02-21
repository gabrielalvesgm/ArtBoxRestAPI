package artboxproject.artboxproject.controllers;

import artboxproject.artboxproject.models.HistoricoCompras;
import artboxproject.artboxproject.services.HistoricoComprasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<HistoricoCompras> createCompra(@Valid @RequestBody HistoricoCompras compra) {
        HistoricoCompras novaCompra = historicoComprasService.createCompra(compra);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaCompra); // Status 201 Created
    }


    // Buscar todas as compras
    @GetMapping
    public ResponseEntity<List<HistoricoCompras>> getAllCompras() {
        List<HistoricoCompras> compras = historicoComprasService.getAllCompras();
        return ResponseEntity.ok(compras); // Status 200 OK
    }

    // Buscar compras por id de cliente
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<HistoricoCompras>> getComprasByClienteId(@PathVariable Long clienteId) {
        List<HistoricoCompras> compras = historicoComprasService.getComprasByClienteId(clienteId);
        if (compras.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(compras);
    }


    // Buscar uma compra específica pelo id de compra
    @GetMapping("/{id}")
    public ResponseEntity<HistoricoCompras> getCompraById(@PathVariable Long id) {
        Optional<HistoricoCompras> compra = historicoComprasService.getCompraById(id);
        if (compra.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(compra.get());
    }
}
