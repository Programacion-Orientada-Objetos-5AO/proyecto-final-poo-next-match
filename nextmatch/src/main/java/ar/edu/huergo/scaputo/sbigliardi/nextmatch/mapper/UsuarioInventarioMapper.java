package ar.edu.huergo.scaputo.sbigliardi.nextmatch.mapper;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.security.UsuarioDTO;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.App;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.security.Rol;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.security.Usuario;


@Component
public class UsuarioInventarioMapper {
    private final ModelMapper modelMapper;

    public UsuarioInventarioMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public App toEntity(AppDTO dto) {
        if (dto == null) return null;

        App app = new App();
        app.setId(dto.getId());
        app.setNombre(dto.getNombre());
        app.setVersion(dto.getVersion());
        app.setDescripcion(dto.getDescripcion());
        return app;
    }

    public AppDTO toDto(App app) {
        if (app == null) return null;

        AppDTO dto = new AppDTO();
        dto.setId(app.getId());
        dto.setVersion(app.getVersion());
        return dto;
    }
}