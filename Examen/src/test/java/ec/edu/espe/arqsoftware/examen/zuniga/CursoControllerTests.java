/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.zuniga;

import ec.edu.espe.arqsoftware.examen.zuniga.controller.CursoController;
import ec.edu.espe.arqsoftware.examen.zuniga.model.Curso;
import ec.edu.espe.arqsoftware.examen.zuniga.service.CursoService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
@WebMvcTest({CursoController.class})
public class CursoControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private Curso nuevoCurso;
    private Curso nuevoCurso2;
    private Curso nuevoCurso3;
    private List<Curso> listaCursos;

    @MockBean
    private CursoService service;

    @BeforeEach
    public void setup() {
        this.nuevoCurso = new Curso("saqwe1231", "25", "Ciencia", "Quimica", 3, new Date(), new BigDecimal(250));
        this.nuevoCurso2 = new Curso("saqwe1231", "25", "Ciencia", "Quimica", 3, new Date(), new BigDecimal(250));
        this.nuevoCurso3 = new Curso("saqwe1231", "25", "Ciencia", "Quimica", 3, new Date(), new BigDecimal(250));
        this.listaCursos = new ArrayList<>();
        this.listaCursos.add(this.nuevoCurso);
        this.listaCursos.add(this.nuevoCurso2);
        this.listaCursos.add(this.nuevoCurso3);
    }

    @Test
    void obtenerCursoPorAreaYNombre() throws Exception {
        List<Curso> cursos = new ArrayList<>();
        cursos.add(nuevoCurso);
        cursos.add(nuevoCurso2);
        cursos.add(nuevoCurso3);
        Mockito.when(this.service.obtainByAreaAndNombre("Ciencia", "Quimica")).thenReturn(cursos);
        this.mvc.perform(MockMvcRequestBuilders.get("/v1/curso/busqueda/Ciencia/Quimica", new Object[0]).contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }
}
