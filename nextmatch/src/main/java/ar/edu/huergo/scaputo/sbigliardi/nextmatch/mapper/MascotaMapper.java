package ar.edu.huergo.scaputo.sbigliardi.nextmatch.mapper;

@Component
public class MascotaMapper {

    public MascotaDTO toDTO(Mascota m) {
        return new MascotaDTO(
            m.getId(),
            m.getNombre(),
            m.getTipo(),
            m.getEdad(),
            m.getAdoptado()
        );
    }

    public Mascota toEntity(NuevaMascotaDTO dto) {
        Mascota m = new Mascota();
        m.setNombre(dto.nombre());
        m.setTipo(dto.tipo());
        m.setEdad(dto.edad());
        m.setAdoptado(false);
        return m;
    }
}
