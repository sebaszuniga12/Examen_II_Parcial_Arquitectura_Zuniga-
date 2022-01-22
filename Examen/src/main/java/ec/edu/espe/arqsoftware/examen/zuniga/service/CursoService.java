/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.zuniga.service;

import ec.edu.espe.arqsoftware.examen.zuniga.dao.CursoRepository;
import ec.edu.espe.arqsoftware.examen.zuniga.model.Curso;
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
        return this.cursoRepository.findByAreaAndNombreLike(area, nombre);
    }

}
