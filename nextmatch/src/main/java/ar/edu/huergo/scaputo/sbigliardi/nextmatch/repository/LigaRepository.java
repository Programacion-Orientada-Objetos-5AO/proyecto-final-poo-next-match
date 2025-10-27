package ar.edu.huergo.scaputo.sbigliardi.nextmatch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.Liga;

@Repository
public interface LigaRepository extends JpaRepository<Liga, Long> {
  
}

