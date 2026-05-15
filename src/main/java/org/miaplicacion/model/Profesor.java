package org.miaplicacion.model;
import jakarta.persistence.*;
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
    private String nombre;
    private String email;
    private int edad;
}
