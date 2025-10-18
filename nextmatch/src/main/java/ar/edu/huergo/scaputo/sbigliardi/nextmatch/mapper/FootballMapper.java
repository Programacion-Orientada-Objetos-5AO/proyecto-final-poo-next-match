package ar.edu.huergo.scaputo.sbigliardi.nextmatch.mapper;

import org.springframework.stereotype.Component;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.FootballAPIDTO;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.Equipo;

@Component
public class FootballMapper {

    public Equipo toEntity(FootballAPIDTO dto) {
        if (dto == null) return null;

        Equipo e = new Equipo();
        e.setId(dto.getId());
        e.setNombre(dto.getNombre());
        e.setPais(dto.getPais());
        e.setFundacion(dto.getFundacion());
        e.setLogo(dto.getLogo());
        e.setEstadio(dto.getEstadio());
        e.setDireccionEstadio(dto.getDireccionEstadio());
        e.setCiudad(dto.getCiudad());
        e.setCapacidadEstadio(dto.getCapacidadEstadio());
        return e;
    }

    public FootballAPIDTO toDto(Equipo e) {
        if (e == null) return null;

        FootballAPIDTO dto = new FootballAPIDTO();
        dto.setId(e.getId());
        dto.setNombre(e.getNombre());
        dto.setPais(e.getPais());
        dto.setFundacion(e.getFundacion());
        dto.setLogo(e.getLogo());
        dto.setEstadio(e.getEstadio());
        dto.setDireccionEstadio(e.getDireccionEstadio());
        dto.setCiudad(e.getCiudad());
        dto.setCapacidadEstadio(e.getCapacidadEstadio());
        return dto;
    }
}
