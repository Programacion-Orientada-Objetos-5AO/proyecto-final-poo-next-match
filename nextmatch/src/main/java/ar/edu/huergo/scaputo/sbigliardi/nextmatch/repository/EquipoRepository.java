package ar.edu.huergo.scaputo.sbigliardi.nextmatch.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.Equipo;

//CrudRepository es una interfaz que proporciona metodos para CRUD (Create, Read, Update, Delete)
//<equipo, Long> indica que el repositorio se encarga de los equipos y que la clave primaria es Long
@Repository
public interface EquipoRepository extends CrudRepository<Equipo, Long> {
    
}
