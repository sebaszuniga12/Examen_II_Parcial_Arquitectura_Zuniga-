/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.zuniga.model;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author sebas
 */
@Data
@Document(collection = "curso")
public class Curso {
    @Id
    private String id;
    private String codigo;
    private String area;
    private Integer duracionHoras;
    private Date fechaInicio;
    private Date fechaCreacion;
    private BigDecimal costo;
}
