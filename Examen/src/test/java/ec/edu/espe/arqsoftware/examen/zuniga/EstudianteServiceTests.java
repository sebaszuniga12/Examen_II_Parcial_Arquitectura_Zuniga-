/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.zuniga;

import ec.edu.espe.arqsoftware.examen.zuniga.dao.EstudianteRepository;
import ec.edu.espe.arqsoftware.examen.zuniga.model.Estudiante;
import ec.edu.espe.arqsoftware.examen.zuniga.service.EstudianteService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
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
public class EstudianteServiceTests {

    @Mock
    private EstudianteRepository repo;

    @InjectMocks
    private EstudianteService service;
    private Estudiante nuevoEstudiante;

    @BeforeEach
    public void setup() {
        LocalDateTime fecha = LocalDateTime.now(ZoneId.of("America/New_York")).withNano(0);
        this.nuevoEstudiante = new Estudiante("123123123", "25", "", "", new Date(), fecha, "INV");
    }

    @Test
    void createCliente() {
        Mockito.when((Estudiante) this.repo.save(this.nuevoEstudiante)).thenReturn(this.nuevoEstudiante);
        Estudiante estudiante = this.service.createEstudiante(nuevoEstudiante);
        Assertions.assertEquals(estudiante, this.nuevoEstudiante);
    }
}
