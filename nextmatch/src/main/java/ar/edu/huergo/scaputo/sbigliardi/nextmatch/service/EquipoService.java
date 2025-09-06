package ar.edu.huergo.scaputo.sbigliardi.nextmatch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.EquipoDTO;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.Equipo;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.repository.EquipoRepository;

@Service
public class EquipoService {
    @Autowired
    private EquipoRepository equipoRepository;

    public List<EquipoDTO> getEquipos() {
        return ((List<Equipo>) this.equipoRepository.findAll()).stream().map(equipo -> new EquipoDTO(equipo.getId(), equipo.getNombre())).toList();
    }

    public Optional<Equipo> getEquipo(Long id) {
        return this.equipoRepository.findById(id);
    }

    public void crearEquipo(EquipoDTO equipoDto) {
        this.equipoRepository.save(new Equipo(equipoDto.nombre()));
    }

    public void actualizarEquipo(Long id, EquipoDTO equipoDto) throws NotFoundException {
        Equipo equipo = this.equipoRepository.findById(id).orElseThrow(() -> new NotFoundException());
        equipo.setNombre(equipoDto.nombre());
        this.equipoRepository.save(equipo);
    }

    public void eliminarEquipo(Long id) {
        this.equipoRepository.deleteById(id);
    }
}

