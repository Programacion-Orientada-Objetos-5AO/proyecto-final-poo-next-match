package ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tecnico")
@Getter
@Setter
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "equipo_actual")
    private String equipoActual;

    @Column
    private Integer edad;

    @Column
    private String nacionalidad;

    public Tecnico(String nombre) {
        this.nombre = nombre;
    }
    
}
