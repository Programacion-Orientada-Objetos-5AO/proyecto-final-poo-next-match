package ar.edu.huergo.scaputo.nextmatch.repository.plato;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ar.edu.huergo.scaputo.nextmatch.entity.plato.Plato;

@Repository
public interface PlatoRepository extends JpaRepository<Plato, Long> {
}