/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.zuniga.controller;

import ec.edu.espe.arqsoftware.examen.zuniga.model.Curso;
import ec.edu.espe.arqsoftware.examen.zuniga.service.CursoService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sebas
 */
@RestController
@Slf4j
@RequestMapping("/v1/curso/")
public class CursoController {

    private final CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

    @GetMapping(value = "busqueda/{area}/{nombre}")
    public ResponseEntity obtenerCursoPorAreaYNombre(@PathVariable("area") String area, @PathVariable("nombre") String nombre) {
        List<Curso> cursos = this.service.obtainByAreaAndNombre(area, nombre);
        if (!cursos.isEmpty()) {
            return ResponseEntity.ok(cursos);
        } else {
            log.error("The curso with area: {} and nombre {} does not exists in the database", area, nombre);
            //TODO: Retornar clase propia
            return ResponseEntity.notFound().build();
        }
    }
}
