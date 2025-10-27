package ar.edu.huergo.scaputo.sbigliardi.nextmatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.Estadistica;

@Repository
public interface EstadisticaRepository extends JpaRepository<Estadistica, Long> {

 
}
