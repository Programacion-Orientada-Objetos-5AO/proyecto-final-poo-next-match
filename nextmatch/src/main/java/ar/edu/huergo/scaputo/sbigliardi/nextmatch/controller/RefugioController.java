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
ar.edu.huergo.scaputo.sbigliardi.nextmatch.service.RefugioService;
import jakarta.validation.Valid;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.RefugioDTO;
import
ar.edu.huergo.scaputo.sbigliardi.nextmatch.mapper.RefugioMapper;
@RestController
@RequestMapping("/api/refugios")
public class RefugioController  {
@Autowired
private RefugioService refugioService;

@Autowired
private RefugioMapper refugioMapper;

@GetMapping
public ResponseEntity<List<RefugioDTO>> obtenerTodosLosRefugios()
{
return
ResponseEntity.ok(refugioMapper.toDTOList(refugioService.obtenerTodosLosRefugios()));
}
@PostMapping
public ResponseEntity<RefugioDTO> crearRefugio(@RequestBody
@Valid RefugioDTO refugioDTO) {
RefugioDTO refugioCreado =
refugioMapper.toDTO(refugioService.crearRefugio(refugioMapper.toEntity(refugioDTO)));
URI location = ServletUriComponentsBuilder.fromCurrentRequest()
.path("/{id}")
.buildAndExpand(refugioCreado.id())
.toUri();
return ResponseEntity.created(location).body(refugioCreado);
}
@GetMapping("/{id}")
public ResponseEntity<RefugioDTO>
obtenerRefugioPorId(@PathVariable Long id) {
return
ResponseEntity.ok(refugioMapper.toDTO(refugioService.obtenerRefugioPorId(id)));
}
@PutMapping("/{id}")
public ResponseEntity<RefugioDTO> actualizarRefugio(@PathVariable
Long id, @RequestBody @Valid RefugioDTO refugioDTO) {
return ResponseEntity.ok(refugioMapper.toDTO(
refugioService.actualizarRefugio(
id,refugioMapper.toEntity(refugioDTO))) );
}
@DeleteMapping("/{id}")
public ResponseEntity<Void> eliminarRefugio(@PathVariable Long id)
{
refugioService.eliminarRefugio(id);
return ResponseEntity.noContent().build(); }

@GetMapping("/nombre")
public ResponseEntity<List<RefugioDTO>>
obtenerRefugiosPorNombre(@RequestParam String nombre) {
return
ResponseEntity.ok(refugioMapper.toDTOList(refugioService.obtenerRefugioPorNombre(nombre)));
}
@GetMapping("/edad")
public ResponseEntity<List<RefugioDTO>>
obtenerRefugiosPorEdad(@RequestParam int edad) {
return
ResponseEntity.ok(refugioMapper.toDTOList(refugioService.obtenerRefugioPorEdad(edad)));
}

}