package ar.edu.huergo.scaputo.sbigliardi.nextmatch.mapper;

import org.springframework.stereotype.Component;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.*;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.Mascota;

@Component
public class MascotaMapper {

    public MascotaDTO toDTO(Mascota m) {
        if (m == null) return null;

        return new MascotaDTO(
            m.getId(),
            m.getNombre(),
            m.getTipo(),
            m.getEdad(),
            m.getAdoptado()
        );
    }

    public Mascota toEntity(NuevaMascotaDTO dto) {
        if (dto == null) return null;

        Mascota m = new Mascota();
        m.setNombre(dto.nombre());
        m.setTipo(dto.tipo());
        m.setEdad(dto.edad());
        m.setAdoptado(false);

        return m;
    }
}
