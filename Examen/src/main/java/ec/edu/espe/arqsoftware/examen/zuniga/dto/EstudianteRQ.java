/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.zuniga.dto;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author sebas
 */
@Data
public class EstudianteRQ {
    private String nombre;
    private String correo;
    private String pais;
    private Date fechaNacimiento;
}
