package ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table (name = "refugios")
@Data // Lombok: genera getters, setters, equals, hashCode, toString, requiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Refugio {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotBlank(message = "El nombre es obligatorio")
@Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")

@NotBlank(message = "El tipo es obligatorio")
@Size(min = 2, max = 100, message = "El tipo debe tener entre 2 y 100 caracteres")
private String tipo;
private int edad;
private boolean adoptado;
}