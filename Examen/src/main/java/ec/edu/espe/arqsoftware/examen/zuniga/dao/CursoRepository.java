/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.zuniga.dao;

import ec.edu.espe.arqsoftware.examen.zuniga.model.Curso;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author sebas
 */
    public interface CursoRepository extends MongoRepository<Curso, String>{
    
    List<Curso> findByAreaAndNombreLike(String area, String nombre);
}
