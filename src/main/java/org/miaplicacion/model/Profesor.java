package org.miaplicacion.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

// Representa una nueva entidad
@Entity
// Tabla de la entidad Profesor
@Table(name = "profesores")
// Usamos Lombok para ahorrarnos los getters y setters
@Data
public class Profesor {
    // ID del profesor
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // Campos base del profesor
    private Long id;
    // Controlamos que el nombre no puede estar vacío
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    // Controlamos que el email tenga formato válido
    @Email(message = "El email no es válido")
    @NotBlank(message = "El email no puede estar vacío")
    private String email;
    private int edad;
}
