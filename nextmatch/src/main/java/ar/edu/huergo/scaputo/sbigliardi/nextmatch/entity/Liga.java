package ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ligas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Liga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int leagueId; // ID real de la API
    private String nombre;
    private int temporada;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "liga_equipos", joinColumns = @JoinColumn(name = "liga_id"))
    @Column(name = "equipo")
    private List<String> equipos;
}
