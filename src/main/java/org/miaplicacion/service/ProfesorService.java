package org.miaplicacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.miaplicacion.model.Profesor;
import org.miaplicacion.repository.ProfesorRepository;
import org.miaplicacion.exception.ProfesorNotFoundException;

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

    // Obtenemos profesor por ID
    public Profesor obtenerProfesorPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProfesorNotFoundException(id));
    }

    // Actualizamos el registro de un profesor por su id
    public Profesor actualizarProfesor(Long id, Profesor profesor) {
        Profesor existente = repository.findById(id)
                .orElseThrow(() -> new ProfesorNotFoundException(id));
        existente.setNombre(profesor.getNombre());
        existente.setEmail(profesor.getEmail());
        existente.setEdad(profesor.getEdad());
        return repository.save(existente);
    }

    // Eliminamos el registro de un profesor por su id
    public void eliminarProfesor(Long id) {
        if (!repository.existsById(id)) {
            throw new ProfesorNotFoundException(id);
        }
        repository.deleteById(id);
    }



}
