package ar.edu.huergo.scaputo.sbigliardi.nextmatch.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import
org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import
ar.edu.huergo.scaputo.sbigliardi.nextmatch.service.MascotaService;
import jakarta.validation.Valid;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.MascotaDTO;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.mapper.MascotaMapper;
@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {
@Autowired
private MascotaService mascotaService;

@Autowired
private MascotaMapper mascotaMapper;
@GetMapping
public ResponseEntity<List<MascotaDTO>> obtenerTodosLosMascotas() {
return
ResponseEntity.ok(mascotaMapper.toDTOList(mascotaService.obtenerTodosLosMascotas()));
}
@PostMapping
public ResponseEntity<MascotaDTO> crearMascota(@RequestBody @Valid
MascotaDTO mascotaDTO) {
MascotaDTO mascotaCreado =
mascotaMapper.toDTO(mascotaService.crearMascota(mascotaMapper.toEntity(mascotaDTO
)));
URI location = ServletUriComponentsBuilder.fromCurrentRequest()
.path("/{id}")
.buildAndExpand(mascotaCreado.id())
.toUri();

return ResponseEntity.created(location).body(mascotaCreado);
}
@GetMapping("/{id}")
public ResponseEntity<MascotaDTO> obtenerMascotaPorId(@PathVariable
Long id) {
return
ResponseEntity.ok(mascotaMapper.toDTO(mascotaService.obtenerMascotaPorId(id))
);
}
@PutMapping("/{id}")
public ResponseEntity<MascotaDTO> actualizarMascota(@PathVariable Long
id, @RequestBody @Valid MascotaDTO mascotaDTO) {
return ResponseEntity.ok(mascotaMapper.toDTO(
mascotaService.actualizarMascota( id,mascotaMapper.toEntity(mascotaDTO))) );
}
@DeleteMapping("/{id}")
public ResponseEntity<Void> eliminarMascota(@PathVariable Long id) {
mascotaService.eliminarMascota(id);
return ResponseEntity.noContent().build(); }
@GetMapping("/nombre")
public ResponseEntity<List<MascotaDTO>>
obtenerMascotaPorNombre(@RequestParam String nombre) {
return
ResponseEntity.ok(mascotaMapper.toDTOList(mascotaService.obtenerMascotaPorNombre(nombre)));
}
@GetMapping("/edad")
public ResponseEntity<List<MascotaDTO>>
obtenerMascotaPorEdad(@RequestParam int edad) {
return
ResponseEntity.ok(mascotaMapper.toDTOList(mascotaService.obtenerMascotaPorEdad(edad)));
}
@GetMapping("/tipo")
public ResponseEntity<List<MascotaDTO>>
obtenerMascotaPorTipo(@RequestParam String tipo) {

return
ResponseEntity.ok(mascotaMapper.toDTOList(mascotaService.obtenerMascotaPorTipo(tipo)));
}

@GetMapping("/adoptado")
public ResponseEntity<List<MascotaDTO>>
obtenerMascotaPorAdoptado(@RequestParam boolean adoptado) {
return
ResponseEntity.ok(mascotaMapper.toDTOList(mascotaService.obtenerMascotaPorAdoptado(adoptado)));
}
}