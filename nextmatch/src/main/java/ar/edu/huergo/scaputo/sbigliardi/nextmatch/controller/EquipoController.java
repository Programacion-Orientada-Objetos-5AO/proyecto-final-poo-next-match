package ar.edu.huergo.scaputo.sbigliardi.nextmatch.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.EquipoDTO;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.Equipo;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.service.EquipoService;

@RestController //Tipo de controller, en este caso un RESTful API controller
@RequestMapping("/equipo") //El dominio con el que acciona el controller
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    @GetMapping // http://localhost:8080/equipo
    public List<EquipoDTO> getEquipos() {
        return this.equipoService.getEquipos();
    }

    @GetMapping("/{id}") // http://localhost:8080/equipo/1
    public ResponseEntity<EquipoDTO> getEquipo(@PathVariable Long id) {
        try {
            Optional<Equipo> equipoOpt = this.equipoService.getEquipo(id); //Optional es un contenedor que puede contener un valor o no, sirve para manejar los casos en los que el dato que se busca puede no existir
            if(equipoOpt.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            Equipo equipo = equipoOpt.get();
            return ResponseEntity.ok(new EquipoDTO(equipo.getId(), equipo.getNombre()));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping //Indica que el metodo es un POST en localhost:8080/equipo
    public ResponseEntity<String> crearEquipo(@RequestBody EquipoDTO equipoDto) { //@RequestBody indica que el cuerpo de la peticion es un JSON y se lo asigna a un objeto EquipoDto
        try {
            this.equipoService.crearEquipo(equipoDto);
            return ResponseEntity.created(null).body("Equipo creado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}") //Indica que el metodo es un PUT en localhost:8080/equipo/1
    public ResponseEntity<String> actualizarEquipo(@PathVariable Long id, @RequestBody EquipoDTO equipoDto) {
        try {
            this.equipoService.actualizarEquipo(id, equipoDto);
            return ResponseEntity.ok("Equipo actualizado correctamente");
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}") //Indica que el metodo es un DELETE en localhost:8080/equipo/1
    public ResponseEntity<String> eliminarEquipo(@PathVariable Long id) {
        try {
            this.equipoService.eliminarEquipo(id);
            return ResponseEntity.ok("Equipo eliminado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
