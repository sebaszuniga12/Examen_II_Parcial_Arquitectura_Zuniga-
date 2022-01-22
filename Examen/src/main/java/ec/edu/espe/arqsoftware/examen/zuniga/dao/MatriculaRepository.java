/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.zuniga.dao;

import ec.edu.espe.arqsoftware.examen.zuniga.model.Matricula;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author sebas
 */
public interface MatriculaRepository extends MongoRepository<Matricula, String>{
     List<Matricula> findByCorreoEstudiante(String correo) ;
}
