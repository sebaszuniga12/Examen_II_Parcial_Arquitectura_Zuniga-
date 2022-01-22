/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.zuniga.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author sebas
 */
@Data
@Document(collection = "matricula")
public class Matricula {
    
    @Id
    private String id;
    private String codigoCurso;
    private String areaCurso;
    private String nombreCurso;
    private Integer duracionHorasCurso;
    private Date fechaInicioCurso;
    private BigDecimal costoCurso;
    private String nombreEstudiante;
    private String correoEstudiante;
    private LocalDateTime fechaCreacion;
    private String estado;
}
