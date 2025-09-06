package ar.edu.huergo.scaputo.sbigliardi.nextmatch.repository.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.security.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByNombre(String nombre);
}


