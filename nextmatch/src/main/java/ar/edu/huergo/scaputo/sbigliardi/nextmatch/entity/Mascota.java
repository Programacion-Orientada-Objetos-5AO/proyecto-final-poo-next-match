package ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Entity //va sin table porque automaticamente hace la de refugio
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true) //tiene que ir si o si en herencia
public class Mascota extends Refugio { //hereda mascota de refugio, los atributos de refugio solo no se ponen aca
@NotBlank(message = "El tipo es obligatorio")
@Size(min = 2, max = 100, message = "La mascota debe tener entre 2 y 100 caracteres")
private String tipo;
@Min(value = 1, message = "debe ser si o no")
private boolean adoptado;
}