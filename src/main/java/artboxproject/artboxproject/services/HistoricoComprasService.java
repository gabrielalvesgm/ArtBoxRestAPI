package artboxproject.artboxproject.services;


import artboxproject.artboxproject.models.HistoricoCompras;
import artboxproject.artboxproject.repositories.HistoricoComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoricoComprasService {


    @Autowired
    private HistoricoComprasRepository historicoComprasRepository;


    //Criando um novo registro de compra
    public HistoricoCompras createCompra(HistoricoCompras compra) {
        return historicoComprasRepository.save(compra);
    }


    //Buscar todas as compras feitas no repositório.
    public List<HistoricoCompras> getAllCompras() {
        return historicoComprasRepository.findAll();
    }


    //Buscar compra por id de cliente
    public List<HistoricoCompras> getComprasByClienteId(Long clienteId) {
        return historicoComprasRepository.findByClienteId(clienteId);
    }


    //Buscar uma compra específica pelo id de compra.
    public Optional<HistoricoCompras> getCompraById(Long id) {
        return historicoComprasRepository.findById(id);
    }


    //Atualizar uma compra pelo Id de compra
    public HistoricoCompras updateCompra(Long id, HistoricoCompras compraDetails) {
        return historicoComprasRepository.findById(id).map(compra -> {
            compra.setDescricao(compraDetails.getDescricao());
            compra.setValor(compraDetails.getValor());
            compra.setDataCompra(compraDetails.getDataCompra());
            return historicoComprasRepository.save(compra);
        }).orElseThrow(() -> new RuntimeException("Uma compra com este ID não existe." + id));
    }


    //Deletar uma compra por id da compra.
    public void deletarCompra(Long id) {
        historicoComprasRepository.deleteById(id);
    }

}
