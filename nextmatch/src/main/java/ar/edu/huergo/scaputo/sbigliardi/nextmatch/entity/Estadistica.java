package ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Estadistica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreEquipo;
    private String nombreLiga;
    private int temporada;

    private int partidosGanados;
    private int partidosEmpatados;
    private int partidosPerdidos;

    private int golesAFavor;
    private int golesEnContra;
    public Estadistica(String nombreEquipo, String nombreLiga, int temporada) {
        this.nombreEquipo = nombreEquipo;
        this.nombreLiga = nombreLiga;
        this.temporada = temporada;
    }
    
}
