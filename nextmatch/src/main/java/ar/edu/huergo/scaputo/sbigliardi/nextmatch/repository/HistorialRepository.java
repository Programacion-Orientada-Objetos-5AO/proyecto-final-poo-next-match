package ar.edu.huergo.scaputo.sbigliardi.nextmatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.Historial;

import java.util.Optional;

@Repository
public interface HistorialRepository extends JpaRepository<Historial, Long> {
    Optional<Historial> buscarHistorial(String equipo1, String equipo2);
}
