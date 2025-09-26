package ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class EquipoDTO {
    @Id
    private Long id;
    private String nombre;
    private int apiId;

    public EquipoDTO() {}

    public EquipoDTO(Long id, String nombre, int apiId) {
        this.id = id;
        this.nombre = nombre;
        this.apiId = apiId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
    }
}
