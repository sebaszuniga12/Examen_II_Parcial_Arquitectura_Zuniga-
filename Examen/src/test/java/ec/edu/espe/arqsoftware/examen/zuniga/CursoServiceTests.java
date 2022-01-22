/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.zuniga;

import ec.edu.espe.arqsoftware.examen.zuniga.dao.CursoRepository;
import ec.edu.espe.arqsoftware.examen.zuniga.model.Curso;
import ec.edu.espe.arqsoftware.examen.zuniga.service.CursoService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author sebas
 */
@ExtendWith(MockitoExtension.class)
public class CursoServiceTests {

    @Mock
    private CursoRepository repo;

    @InjectMocks
    private CursoService service;
    private Curso nuevoCurso;
    private Curso nuevoCurso2;
    private Curso nuevoCurso3;
    private List<Curso> listaCursos;

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
    void obtainByAreaAndNombre() {
        Mockito.when(this.repo.findByAreaAndNombreLike("Ciencia", "Qui")).thenReturn(this.listaCursos);
        List<Curso> curso = this.service.obtainByAreaAndNombre("Ciencia", "Qui");
        try {
            Assertions.assertEquals(this.listaCursos, curso);
        } catch (Exception e) {
            Logger.getLogger(CursoServiceTests.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
