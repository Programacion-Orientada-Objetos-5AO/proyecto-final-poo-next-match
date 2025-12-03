package ar.edu.huergo.scaputo.sbigliardi.nextmatch.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.Refugio;
@Repository
public interface RefugioRepository extends JpaRepository<Refugio, Long> {
    List<Refugio> findByNombreContainingIgnoreCase(String nombre);
    List<Refugio> findByEdad(int edad);
}