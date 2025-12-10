package ar.edu.huergo.scaputo.sbigliardi.nextmatch.service;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.Mascota;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.repository.MascotaRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository repo;

    public Mascota crear(Mascota m) {
        return repo.save(m);
    }

    public List<Mascota> obtenerTodos() {
        return repo.findAll();
    }

    public Mascota obtenerPorId(Long id) {
        return repo.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Mascota no encontrada"));
    }

    public Mascota actualizar(Long id, Mascota datos) {
        Mascota m = obtenerPorId(id);

        m.setNombre(datos.getNombre());
        m.setTipo(datos.getTipo());
        m.setEdad(datos.getEdad());
        m.setAdoptado(datos.getAdoptado());

        return repo.save(m);
    }

    public void eliminar(Long id) {
        Mascota m = obtenerPorId(id);
        repo.delete(m);
    }
}
