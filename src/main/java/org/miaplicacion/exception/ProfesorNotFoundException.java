package org.miaplicacion.exception;

// Mensaje de alerta informando de que el profesor con id x no existe
public class ProfesorNotFoundException extends RuntimeException {
    public ProfesorNotFoundException(Long id) {
        super("Profesor no encontrado con id: " + id);
    }
}