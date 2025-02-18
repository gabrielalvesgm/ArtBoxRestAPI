package artboxproject.artboxproject.repositories;

import artboxproject.artboxproject.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    //Metodo para encontrar cliente por email.
    Optional<Cliente> findByEmail(String email);

    //Metodo para encontrar cliente por cpf.
    Optional<Cliente> findByCpf(String cpf);
}
