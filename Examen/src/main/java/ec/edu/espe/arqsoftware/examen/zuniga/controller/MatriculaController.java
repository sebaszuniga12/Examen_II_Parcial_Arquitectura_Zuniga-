/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.zuniga.controller;

import ec.edu.espe.arqsoftware.examen.zuniga.dto.MatriculaRQ;
import ec.edu.espe.arqsoftware.examen.zuniga.model.Matricula;
import ec.edu.espe.arqsoftware.examen.zuniga.service.MatriculaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sebas
 */
@RestController
@Slf4j
@RequestMapping("/v1/matricula")
public class MatriculaController {

    private final MatriculaService service;

    public MatriculaController(MatriculaService service) {
        this.service = service;
    }
    
    
     @PostMapping
    @ApiOperation(value = "Crear una matricula",
            notes = "Crea un cliente de acuerdo a los datos enviados")
    @ApiResponses(value = {
        @ApiResponse(code = 201,
                message = "Cuando se crea una matricula de acuerdo a los datos enviados"),
        @ApiResponse(code = 400,
                message = "Cuando no se puede crear una matricula con los datos enviados")
    })
    public ResponseEntity crearMatricula(@RequestBody MatriculaRQ request) {
        try {
            Matricula matricula = new Matricula();
            matricula.setCodigoCurso(request.getCodigoCurso());
           matricula.setCorreoEstudiante(request.getCorreoEstudiante());
            log.info("The matricula with this information: {} will be inserted in the database", matricula);
            Matricula response = this.service.createMatricula(matricula);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            String exceptionMessage = e.getMessage();
            log.error("An error occurred while creating the Estudiante {} - Returning a Bad Request - Caused by: {}",
                    request,
                    exceptionMessage);
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("hola");
        }
    }

}
