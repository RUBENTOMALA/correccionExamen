package ec.edu.espe.examen.tomala.dao;

import org.springframework.data.repository.CrudRepository;

import ec.edu.espe.examen.tomala.domain.DocenteMateria;
import ec.edu.espe.examen.tomala.domain.DocenteMateriaPK;


public interface DocenteMateriaRepository extends CrudRepository<DocenteMateria, DocenteMateriaPK> {

}
