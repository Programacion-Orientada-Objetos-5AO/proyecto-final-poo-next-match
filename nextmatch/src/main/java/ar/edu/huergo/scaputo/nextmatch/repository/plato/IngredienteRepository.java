package ar.edu.huergo.scaputo.nextmatch.repository.plato;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.huergo.scaputo.nextmatch.entity.equipo.Ingrediente;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {
    List<Ingrediente> findByNombreContainingIgnoreCase(String nombre);
}
