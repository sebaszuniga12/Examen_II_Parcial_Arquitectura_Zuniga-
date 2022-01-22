/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.zuniga.service;

import ec.edu.espe.arqsoftware.examen.zuniga.dao.CursoRepository;
import ec.edu.espe.arqsoftware.examen.zuniga.dao.EstudianteRepository;
import ec.edu.espe.arqsoftware.examen.zuniga.dao.MatriculaRepository;
import ec.edu.espe.arqsoftware.examen.zuniga.model.Curso;
import ec.edu.espe.arqsoftware.examen.zuniga.model.Estudiante;
import ec.edu.espe.arqsoftware.examen.zuniga.model.Matricula;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author sebas
 */
@Service
@Slf4j
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final CursoRepository cursoRepository;
    private final EstudianteRepository estudianteRepository;

    public MatriculaService(MatriculaRepository matriculaRepository, CursoRepository cursoRepository, EstudianteRepository estudianteRepository) {
        this.matriculaRepository = matriculaRepository;
        this.cursoRepository = cursoRepository;
        this.estudianteRepository = estudianteRepository;
    }

    public Matricula createMatricula(Matricula matricula) {
        Optional<Estudiante> estudianteOpt = this.estudianteRepository.findByCorreo(matricula.getCorreoEstudiante());
        if (estudianteOpt.isPresent()) {
            List<Matricula> matriculas = this.matriculaRepository.findByCorreoEstudiante(matricula.getCorreoEstudiante());
            if (matriculas.size() <= 2) {
                Optional<Curso> cursoOpt = this.cursoRepository.findByCodgio(matricula.getCodigoCurso());
                if(cursoOpt.isPresent()){
                LocalDateTime fecha = LocalDateTime.now(ZoneId.of("America/New_York")).withNano(0);
                matricula.setAreaCurso(cursoOpt.get().getArea());
                matricula.setCostoCurso(cursoOpt.get().getCosto());
                matricula.setDuracionHorasCurso(cursoOpt.get().getDuracionHoras());
                matricula.setEstado("ACT");
                matricula.setFechaCreacion(fecha);
                matricula.setFechaInicioCurso(cursoOpt.get().getFechaInicio());
                matricula.setNombreCurso(cursoOpt.get().getNombre());
                matricula.setNombreEstudiante(estudianteOpt.get().getNombre());
                return this.matriculaRepository.save(matricula);
                }
                else{
                   throw new RuntimeException("No existe el curso ingresado");
                }
           
            } else {
                throw new RuntimeException("Ya se encuentra matriculado en dos cursos");
            }

        } else {
            throw new RuntimeException("No existe el estudiante ");
        }

    }
}
