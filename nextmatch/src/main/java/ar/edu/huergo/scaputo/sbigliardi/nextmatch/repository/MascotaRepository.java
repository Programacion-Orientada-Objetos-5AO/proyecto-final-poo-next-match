package ar.edu.huergo.scaputo.sbigliardi.nextmatch.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.Mascota;
@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
List<Mascota> findByNombreContainingIgnoreCase(String nombre);
List<Mascota> findByEdad(int edad);
List<Mascota> findByTipoContainingIgnoreCase(String tipo);
List<Mascota> findByAdoptado(int adoptado);
}