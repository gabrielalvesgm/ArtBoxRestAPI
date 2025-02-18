package artboxproject.artboxproject.repositories;

import artboxproject.artboxproject.models.HistoricoCompras;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoricoComprasRepository extends JpaRepository<HistoricoCompras, Long> {

    //Metodo get para buscar todas as compras de um cliente específico.
    List<HistoricoCompras> findByClienteId(Long clienteId);
}
