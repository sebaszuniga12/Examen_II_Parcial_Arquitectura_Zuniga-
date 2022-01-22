/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.zuniga.controller;

import ec.edu.espe.arqsoftware.examen.zuniga.dto.EstudianteRQ;
import ec.edu.espe.arqsoftware.examen.zuniga.model.Estudiante;
import ec.edu.espe.arqsoftware.examen.zuniga.service.EstudianteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author sebas
 */
@RestController
@Slf4j
@RequestMapping("/v1/estudiante")
public class EstudianteController {

    private final EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    @PostMapping
    @ApiOperation(value = "Crear un estudiante",
            notes = "Crea un cliente de acuerdo a los datos enviados")
    @ApiResponses(value = {
        @ApiResponse(code = 201,
                message = "Cuando se crea un estudiante de acuerdo a los datos enviados"),
        @ApiResponse(code = 400,
                message = "Cuando no se puede crear un estudiante con los datos enviados")
    })
    public ResponseEntity crearEstudiante(@RequestBody EstudianteRQ request) {
        try {
            Estudiante estudiante = new Estudiante();
            estudiante.setNombre(request.getNombre());
            estudiante.setCorreo(request.getCorreo());
            estudiante.setPais(request.getPais());
            estudiante.setFechaNacimiento(request.getFechaNacimiento());
            log.info("The estudiante with this information: {} will be inserted in the database", estudiante);
            Estudiante response = this.service.createEstudiante(estudiante);
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
