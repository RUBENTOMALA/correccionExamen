package ec.edu.espe.examen.tomala.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ec.edu.espe.examen.tomala.domain.Especialidad;

public interface EspecialidadRepository extends CrudRepository<Especialidad, String> {

    List<Especialidad> findByNombreContaining(String nombre);

}
