package ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipos")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    // ID que devuelve la API externa
    private Integer apiId;

    public Equipo() {}

    public Equipo(String nombre, Integer apiId) {
        this.nombre = nombre;
        this.apiId = apiId;
    }

    public Equipo(Long id, String nombre, Integer apiId) {
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Equipo other)) return false;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Equipo [id=" + id + ", nombre=" + nombre + ", apiId=" + apiId + "]";
    }
}
