package org.miaplicacion.controller;

import org.miaplicacion.model.Profesor;
import org.miaplicacion.service.ProfesorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(ProfesorController.class)
public class ProfesorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProfesorService service;

    @Test
    void testListarTodosProfesoresEndpoint() throws Exception {
        Profesor profesor = new Profesor();
        profesor.setNombre("Ana");

        when(service.obtenerTodosProfesores()).thenReturn(List.of(profesor));

        mockMvc.perform(get("/api/profesores"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].nombre").value("Ana"));
    }
}