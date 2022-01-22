/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.zuniga.service;

import ec.edu.espe.arqsoftware.examen.zuniga.dao.EstudianteRepository;
import ec.edu.espe.arqsoftware.examen.zuniga.model.Estudiante;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author sebas
 */
@Service
@Slf4j
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public Estudiante createEstudiante(Estudiante estudiante) {
        Optional<Estudiante> estudianteOpt = this.estudianteRepository.findByCorreo(estudiante.getCorreo());
        if (!estudianteOpt.isPresent()) {
            LocalDateTime fecha = LocalDateTime.now(ZoneId.of("America/New_York")).withNano(0);
            estudiante.setEstado("ACT");
            estudiante.setFechaCreacion(fecha);
            return this.estudianteRepository.save(estudiante);
        } else {
            throw new RuntimeException("Ya existe en la base de datos");
        }
    }

}
