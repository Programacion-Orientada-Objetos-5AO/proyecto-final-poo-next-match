package ar.edu.huergo.scaputo.sbigliardi.nextmatch.service;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.Mascota;
import
ar.edu.huergo.scaputo.sbigliardi.nextmatch.repository.MascotaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class MascotaService {
@Autowired
private MascotaRepository mascotaRepository;
public List<Mascota> obtenerTodosLosMascotas() {
return mascotaRepository.findAll();
}
public Mascota obtenerMascotaPorId(Long id) throws
EntityNotFoundException {
return mascotaRepository.findById(id)
.orElseThrow(() -> new EntityNotFoundException("Mascota no encontrada"));
}
public Mascota crearMascota(Mascota mascota) {
return mascotaRepository.save(mascota);
}
public Mascota actualizarMascota(Long id, Mascota mascota) throws
EntityNotFoundException {
Mascota mascotaExistente = obtenerMascotaPorId(id);
mascotaExistente.setNombre(mascota.getNombre());
mascotaExistente.setEdad(mascota.getEdad());
mascotaExistente.setTipo(mascota.getTipo());
mascotaExistente.setAdoptado(mascota.getAdoptado()); //Aca se ponen todos.
return mascotaRepository.save(mascotaExistente);
}
public void eliminarMascota(Long id) throws EntityNotFoundException {
Mascota mascota = obtenerMascotaPorId(id);
mascotaRepository.delete(mascota);
}
public List<Mascota> obtenerMascotaPorNombre(String nombre) {
return
mascotaRepository.findByNombreContainingIgnoreCase(nombre); //este esta en repository
}

public List<Mascota> obtenerMascotaPorEdad(int edad) { //este esta en repository
return mascotaRepository.findByEdad(edad);
}
public List<Mascota> obtenerMascotaPorTipo(String tipo) { //este esta en repository
return mascotaRepository.findByTipoContainingIgnoreCase(tipo);
}

public List<Mascota> obtenerMascotaPorAdoptado(int adoptado) { //este esta en repository
return mascotaRepository.findByAdoptado(adoptado);
}
public List<Mascota> resolverRefugios(List<Long> mascotaIds) throws
IllegalArgumentException, EntityNotFoundException {
if (mascotaIds == null || mascotaIds.isEmpty()) {
throw new IllegalArgumentException("Debe especificar al menos un Mascota");
}
List<Mascota> mascotas = mascotaRepository.findAllById(mascotaIds);
if (mascotas.size() !=
mascotaIds.stream().filter(Objects::nonNull).distinct()
.count()) {
throw new EntityNotFoundException("Uno o más mascotas no existen");
}
return mascotas;
}
}