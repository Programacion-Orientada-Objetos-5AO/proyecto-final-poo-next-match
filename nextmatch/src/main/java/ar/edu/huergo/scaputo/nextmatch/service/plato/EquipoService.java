package ar.edu.huergo.scaputo.nextmatch.service.plato;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.huergo.scaputo.nextmatch.entity.equipo.Equipo;
import ar.edu.huergo.scaputo.nextmatch.repository.plato.EquipoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class EquipoService {
    @Autowired
    private EquipoRepository equipoRepository;

    public List<Equipo> obtenerTodosLosEquipos() {
        return equipoRepository.findAll();
    }

    public Equipo obtenerEquipoPorId(Long id) throws EntityNotFoundException {
        return equipoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Equipo no encontrado"));
    }

    public Equipo crearEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public Equipo actualizarEquipo(Long id, Equipo equipo) throws EntityNotFoundException {
        Equipo equipoExistente = obtenerEquipoPorId(id);
        equipoExistente.setNombre(equipo.getNombre());
        equipoExistente.setDescripcion(equipo.getDescripcion());
        equipoExistente.setPrecio(equipo.getPrecio());
        return equipoRepository.save(equipoExistente);
    }

    public void eliminarEquipo(Long id) throws EntityNotFoundException {
        Equipo equipo = obtenerEquipoPorId(id);
        equipoRepository.delete(equipo);
    }
}
