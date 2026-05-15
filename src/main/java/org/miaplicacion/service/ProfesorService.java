package org.miaplicacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.miaplicacion.model.Profesor;
import org.miaplicacion.repository.ProfesorRepository;

import  java.util.List;

// Anotación que declara el servicio
@Service
public class ProfesorService {

    // Anotación que instancia el repositorio mediante inyección sin tener que crearlo
    @Autowired
    private ProfesorRepository repository;

    // Metodo para crear un profesor en la base de datos
    public Profesor guardarProfesor(Profesor profesor){
        return repository.save(profesor);
    }

    // Obtenemos todos los profesores guardados
    public List<Profesor> obtenerTodosProfesores() {
        return repository.findAll();
    }
}
