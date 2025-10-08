package ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int apiId; // ID que usa la API externa

    public Equipo() {}

    public Equipo(Long id, String nombre, int apiId) {
        this.id = id;
        this.nombre = nombre;
        this.apiId = apiId;
  
    }

    public Equipo(String nombre, int apiId) {
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
