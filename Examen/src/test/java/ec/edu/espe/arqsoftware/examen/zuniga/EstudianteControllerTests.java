/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.zuniga;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import ec.edu.espe.arqsoftware.examen.zuniga.controller.EstudianteController;
import ec.edu.espe.arqsoftware.examen.zuniga.dto.EstudianteRQ;
import ec.edu.espe.arqsoftware.examen.zuniga.model.Estudiante;
import ec.edu.espe.arqsoftware.examen.zuniga.service.EstudianteService;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 *
 * @author sebas
 */

public class EstudianteControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EstudianteRQ nuevoEstudiRQ;
    private Estudiante nuevoEstudi;

    @MockBean
    private EstudianteService service;

    @BeforeEach
    public void setup() {
        LocalDateTime fecha = LocalDateTime.now(ZoneId.of("America/New_York")).withNano(0);
        this.nuevoEstudiRQ = new EstudianteRQ("25", "", "", new Date());
        this.nuevoEstudi = new Estudiante("123123123", "25", "", "", new Date(), fecha, "INV");
    }

    @Test
    void createClienteTest() throws Exception {
        Estudiante request = new Estudiante();
        request.setCorreo(this.nuevoEstudiRQ.getCorreo());
        request.setNombre(this.nuevoEstudiRQ.getNombre());
        request.setFechaNacimiento(this.nuevoEstudiRQ.getFechaNacimiento());
        request.setPais(this.nuevoEstudiRQ.getPais());
        Mockito.when(this.service.createEstudiante(request)).thenReturn(this.nuevoEstudi);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = (ObjectWriter) mapper.writer().withDefaultPrettyPrinter();
        String requestBody = ow.writeValueAsString(this.nuevoEstudiRQ);
        this.mvc.perform(MockMvcRequestBuilders.post("/v1/estudiante", new Object[0]).contentType(MediaType.APPLICATION_JSON).content(requestBody)).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8"));
    }
}
