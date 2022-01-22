/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.zuniga.service;

import ec.edu.espe.arqsoftware.examen.zuniga.dao.CursoRepository;
import ec.edu.espe.arqsoftware.examen.zuniga.model.Curso;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author sebas
 */
@Service
@Slf4j
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> obtainByAreaAndNombre(
            String area, String nombre) {
        List<Curso> cursos = this.cursoRepository.findByAreaAndNombreLike(area, nombre);
        List<Curso> cursosFechas = new ArrayList<>();
        Date newDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(newDate);
        calendar.add(Calendar.MONTH, 6);
        if (!cursos.isEmpty()) {
            for (Curso curso : cursos) {
                if (curso.getFechaInicio().after(newDate) && !curso.getFechaInicio().after(calendar.getTime())) {
                    cursosFechas.add(curso);
                }
            }
            if (!cursosFechas.isEmpty()) {
                return cursosFechas;
            } else {
                log.warn("Ningun curso coincide con las fechas establecidas {} y {}", area, nombre);
                throw new RuntimeException("Ningun curso coincide con las fechas establecidas");
            }
        } else {
            log.warn("Ningun curso coincide con los parametros {} y {}", area, nombre);
            throw new RuntimeException("Ningun curso coincide con los parametros ingresados");
        }
    }

}
