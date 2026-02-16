package ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "equipos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Equipo {

    @Id
    private int id;

    private String nombre;
    private String pais;
    private int fundacion;
    private String logo;
    private String estadio;
    private String direccionEstadio;
    private String ciudad;
    private int capacidadEstadio;

    public Equipo(String nombre) {
        this.nombre = nombre;
    }
}
