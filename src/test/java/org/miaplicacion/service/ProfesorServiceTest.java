package org.miaplicacion.service;

import org.miaplicacion.model.Profesor;
import org.miaplicacion.repository.ProfesorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProfesorServiceTest {

    @Mock
    private ProfesorRepository repository;

    @InjectMocks
    private ProfesorService service;

    private Profesor profesor;

    @BeforeEach
    void setUp() {
        profesor = new Profesor();
        profesor.setId(2L);
        profesor.setNombre("Juan Perez");
        profesor.setEmail("juanPerez@ejemplo.com");
        profesor.setEdad(69);
    }

    @Test
    void testGuardarProfesor() {
        when(repository.save(any(Profesor.class))).thenReturn(profesor);
        Profesor guardado = service.guardarProfesor(new Profesor());
        assertNotNull(guardado);
        assertEquals("Juan Perez", guardado.getNombre());
        verify(repository, times(1)).save(any(Profesor.class));
    }

    @Test
    void testObtenerTodosProfesores() {
        when(repository.findAll()).thenReturn(List.of(profesor));
        List<Profesor> lista = service.obtenerTodosProfesores();
        assertFalse(lista.isEmpty());
        assertEquals(1, lista.size());
        verify(repository, times(1)).findAll();
    }
}