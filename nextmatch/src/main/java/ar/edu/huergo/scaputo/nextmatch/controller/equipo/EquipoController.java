package ar.edu.huergo.scaputo.nextmatch.controller.equipo;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ar.edu.huergo.scaputo.nextmatch.dto.equipo.CrearActualizarEquipoDTO;
import ar.edu.huergo.scaputo.nextmatch.dto.equipo.MostrarEquipoDTO;
import ar.edu.huergo.scaputo.nextmatch.entity.equipo.Equipo;
import ar.edu.huergo.scaputo.nextmatch.mapper.equipo.EquipoMapper;
import ar.edu.huergo.scaputo.nextmatch.service.plato.EquipoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {
    @Autowired
    private EquipoService equipoService;

    @Autowired
    private EquipoMapper equipoMapper;

    @GetMapping
    public ResponseEntity<List<MostrarEquipoDTO>> obtenerTodosLosEquipos() {
        List<Equipo> equipos = equipoService.obtenerTodosLosEquipos();
        List<MostrarEquipoDTO> equiposDTO = equipoMapper.toDTOList(equipos);
        return ResponseEntity.ok(equiposDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MostrarEquipoDTO> obtenerEquipoPorId(@PathVariable Long id) {
        Equipo equipo = equipoService.obtenerEquipoPorId(id);
        MostrarEquipoDTO equipoDTO = equipoMapper.toDTO(equipo);
        return ResponseEntity.ok(equipoDTO);
    }

    @PostMapping
    public ResponseEntity<MostrarEquipoDTO> crearEquipo(@Valid @RequestBody CrearActualizarEquipoDTO equipoDTO) {
        Equipo equipo = equipoMapper.toEntity(equipoDTO);
        Equipo equipoCreado = equipoService.crearEquipo(equipo);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(equipoCreado.getId()).toUri();
        return ResponseEntity.created(location).body(equipoMapper.toDTO(equipoCreado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MostrarEquipoDTO> actualizarEquipo(@PathVariable Long id,
            @Valid @RequestBody CrearActualizarEquipoDTO equipoDTO) {
        Equipo equipo = equipoMapper.toEntity(equipoDTO);
        Equipo equipoActualizado = equipoService.actualizarEquipo(id, equipo);
        return ResponseEntity.ok(equipoMapper.toDTO(equipoActualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEquipo(@PathVariable Long id) {
        equipoService.eliminarEquipo(id);
        return ResponseEntity.noContent().build();
    }
}
