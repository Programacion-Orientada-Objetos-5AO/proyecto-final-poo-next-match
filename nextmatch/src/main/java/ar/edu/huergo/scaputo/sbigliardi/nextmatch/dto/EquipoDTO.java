package ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto;

public class EquipoDTO {

    private Long id;
    private String nombre;
    private Integer apiId;

    public EquipoDTO() {}

    public EquipoDTO(Long id, String nombre, Integer apiId) {
        this.id = id;
        this.nombre = nombre;
        this.apiId = apiId;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public Integer getApiId() { return apiId; }

    public void setId(Long id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApiId(Integer apiId) { this.apiId = apiId; }
}
