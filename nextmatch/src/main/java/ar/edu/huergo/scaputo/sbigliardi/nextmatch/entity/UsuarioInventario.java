package ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "usuarioInventario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioInventario {

    @Id
    private int id;

    private String nombre;
    private String categoria;
    private double precio;
    private Integer stock;
    
    public UsuarioInventario(String nombre, String categoria, double precio, Integer stock) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }
}
