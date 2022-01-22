/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.zuniga.dao;

import ec.edu.espe.arqsoftware.examen.zuniga.model.Estudiante;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author sebas
 */
public interface EstudianteRepository extends MongoRepository<Estudiante, String> {
    Optional<Estudiante> findByCorreo(String correo) ;
    
}
