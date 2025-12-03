package ar.edu.huergo.scaputo.sbigliardi.nextmatch.mapper;

import org.springframework.stereotype.Component;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.MascotaDTO;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.Mascota;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
//Un Mapper es una clase que se encarga de convertir un objeto de un tipo a otro.
//En este caso, se encarga de convertir un objeto Plato a un objeto PlatoDTO y viceversa.
//Esto es útil para evitar que el controlador se encargue de la conversión de objetos.
@Component
public class MascotaMapper {
/**
* Convierte una entidad Plato a PlatoDTO
*/
public MascotaDTO toDTO(Mascota mascota) {
if (mascota == null) {
return null;

}
return new MascotaDTO(
mascota.getId(),
mascota.getNombre(),
mascota.getEdad(),
mascota.getTipo(),
mascota.getAdoptado()
);
}
/**
* Convierte un PlatoDTO a entidad Plato
*/
public Mascota toEntity(MascotaDTO dto) {
if (dto == null) {
return null;
}
Mascota mascota = new Mascota();
mascota.setNombre(dto.nombre());
mascota.setEdad(dto.edad());
mascota.setTipo(dto.tipo());
mascota.setAdoptado(dto.adoptado());
return mascota;

}
/**
* Convierte una lista de entidades Plato a lista de PlatoDTO
*/
public List<MascotaDTO> toDTOList(List<Mascota> mascotas) {
if (mascotas == null) {
return new ArrayList<>();
}
return mascotas.stream()
.map(this::toDTO)
.collect(Collectors.toList());
}
}