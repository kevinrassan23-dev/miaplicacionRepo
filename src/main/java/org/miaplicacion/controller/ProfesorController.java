package org.miaplicacion.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.miaplicacion.model.Profesor;
import org.miaplicacion.service.ProfesorService;
import java.util.List;

// Anotación para instanciar el Controlador
@RestController
// Url: http://localhost:8080/api/profesores
@RequestMapping("/api/profesores")
public class ProfesorController {

    // Anotación para inyectar el servicio
    @Autowired
    private ProfesorService service;

    // Anotación para crear nuevos registros
    @PostMapping
    // Metodo para crear nuevos profesores en la base de datos
    public Profesor crearProfesor(@Valid @RequestBody Profesor profesor) {
        return service.guardarProfesor(profesor);
    }

    // Anotación para obtener los registros de la base de datos por id
    @GetMapping
    public List<Profesor> listarTodosProfesores() {

        return service.obtenerTodosProfesores();
    }

    // Anotación para obtener un registro por id de la base de datos
    @GetMapping("/{id}")
    public Profesor obtenerProfesorPorId(@PathVariable Long id) {
        return service.obtenerProfesorPorId(id);
    }

    // Anotación para actualizar los registros de la base de datos
    @PutMapping("/{id}")
    public Profesor actualizarProfesor(@PathVariable Long id, @Valid @RequestBody Profesor profesor) {
        return service.actualizarProfesor(id, profesor);
    }

    // Anotación para eliminar los registros de la base de datos
    @DeleteMapping("/{id}")
    public void eliminarProfesor(@PathVariable Long id) {
        service.eliminarProfesor(id);
    }
}
