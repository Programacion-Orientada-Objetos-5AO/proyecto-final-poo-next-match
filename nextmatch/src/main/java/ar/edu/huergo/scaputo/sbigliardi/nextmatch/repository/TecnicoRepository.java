package ar.edu.huergo.scaputo.sbigliardi.nextmatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.Tecnico;
import java.util.Optional;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
    Optional<Tecnico> findByNombreIgnoreCase(String nombre);
}
