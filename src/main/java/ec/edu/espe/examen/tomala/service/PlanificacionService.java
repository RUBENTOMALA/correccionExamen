package ec.edu.espe.examen.tomala.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import ec.edu.espe.examen.tomala.dao.DocenteMateriaRepository;
import ec.edu.espe.examen.tomala.dao.DocenteRepository;
import ec.edu.espe.examen.tomala.dao.MateriaRepository;
import ec.edu.espe.examen.tomala.domain.DocenteMateria;
import ec.edu.espe.examen.tomala.service.exception.CreacionException;
import jakarta.transaction.Transactional;

@Service
public class PlanificacionService {
    private final DocenteRepository docenteRepository;
    private final MateriaRepository materiaRepository;
    private final DocenteMateriaRepository docenteMateriaRepository;

    public PlanificacionService(DocenteRepository docenteRepository, MateriaRepository materiaRepository,
            DocenteMateriaRepository docenteMateriaRepository) {
        this.docenteRepository = docenteRepository;
        this.materiaRepository = materiaRepository;
        this.docenteMateriaRepository = docenteMateriaRepository;
    }

    @Transactional
    public DocenteMateria create(DocenteMateria docenteMateria) {
        try {
            if (docenteMateria.getPK().getCodDocente() != null) {
                if (docenteMateria.getPK().getCodMateria()!=null) {
                    if (docenteMateria.getAlumnosMatriculados() > 0) {
                        if (docenteMateria.getPromedioCurso().compareTo(BigDecimal.ZERO) >0) {
                            return this.docenteMateriaRepository.save(docenteMateria);
                        }else{
                            throw new CreacionException("El curso no puede tener un promedio menor o igual a 0: " + docenteMateria.getPromedioCurso());
                        }
                    }
                    else{
                        throw new CreacionException("No se puede crear  el registro porque debe existir almenos 1 alumno matriculado: " + docenteMateria.getAlumnosMatriculados());
                    }
                }else{
                    throw new CreacionException("No se encontró ninguna materia asociado al ID ingresado: " + docenteMateria.getPK().getCodMateria());
                }
            }else{
                throw new CreacionException("No se encontró ninguna docente asociado al ID ingresado: " + docenteMateria.getPK().getCodDocente());
            }
            
        } catch (Exception e) {
            throw new CreacionException("Ocurrio un error al crear el registro : " + docenteMateria.toString(), e);
        }
    }

}
