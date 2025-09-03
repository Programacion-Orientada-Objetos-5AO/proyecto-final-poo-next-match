package ar.edu.huergo.scaputo.nextmatch.repository.plato;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.huergo.scaputo.nextmatch.entity.equipo.Equipo;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {
}