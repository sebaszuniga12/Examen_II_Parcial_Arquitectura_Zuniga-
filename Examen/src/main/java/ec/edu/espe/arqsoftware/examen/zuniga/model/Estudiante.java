/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.zuniga.model;

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
@Document(collection = "estudiante")
public class Estudiante {
    @Id
    private String id;
    private String nombre;
    private String correo;
    private String pais;
    private Date fechaNacimiento;
    private LocalDateTime fechaCreacion;
    private String estado;

    public Estudiante(String id, String nombre, String correo, String pais, Date fechaNacimiento, LocalDateTime fechaCreacion, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.pais = pais;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }

    public Estudiante() {
    }
    
    
    
}
