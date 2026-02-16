package ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "historial")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Historial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String equipo1;
    private String equipo2;

    private int ganados1;
    private int empatados;
    private int ganados2;
    public Historial(String equipo1, String equipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }
    
}
