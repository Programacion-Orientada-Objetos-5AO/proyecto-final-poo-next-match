package ar.edu.huergo.scaputo.sbigliardi.nextmatch.service;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.Refugio;
import
ar.edu.huergo.scaputo.sbigliardi.nextmatch.repository.RefugioRepository;
import jakarta.persistence.EntityNotFoundException;
@Service
public class RefugioService {
@Autowired
    private RefugioRepository refugioRepository;
    public List<Refugio> obtenerTodosLosRefugios() {
    return refugioRepository.findAll();
    }
    public Refugio obtenerRefugioPorId(Long id) throws
    EntityNotFoundException {
    return refugioRepository.findById(id)
    .orElseThrow(() -> new EntityNotFoundException("Ingredienteno encontrado"));
    }
public Refugio crearRefugio(Refugio refugio) {
return refugioRepository.save(refugio);

}
public Refugio actualizarRefugio(Long id, Refugio refugio)
throws EntityNotFoundException {
Refugio refugioExistente = obtenerRefugioPorId(id);
refugioExistente.setNombre(refugio.getNombre());
refugioExistente.setEdad(refugio.getEdad());
return refugioRepository.save(refugioExistente);
}
public void eliminarRefugio(Long id) throws
EntityNotFoundException {
Refugio refugio = obtenerRefugioPorId(id);
refugioRepository.delete(refugio);
}
public List<Refugio> obtenerRefugioPorNombre(String nombre) {
return
refugioRepository.findByNombreContainingIgnoreCase(nombre);
}
public List<Refugio> obtenerRefugioPorEdad(int edad) {
return refugioRepository.findByEdad(edad);
}
public List<Refugio> resolverRefugios(List<Long> refugiosIds)
throws IllegalArgumentException, EntityNotFoundException {
if (refugiosIds == null || refugiosIds.isEmpty()) {
throw new IllegalArgumentException("Debe especificar al menos un ingrediente");
}
List<Refugio> ingredientes =
refugioRepository.findAllById(refugiosIds);
if (ingredientes.size() !=
refugiosIds.stream().filter(Objects::nonNull).distinct()
.count()) {
throw new EntityNotFoundException("Uno o más ingredientes no existen");
}
return ingredientes;
}
}