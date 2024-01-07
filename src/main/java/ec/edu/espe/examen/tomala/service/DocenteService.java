package ec.edu.espe.examen.tomala.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.espe.examen.tomala.dao.DocenteRepository;
import ec.edu.espe.examen.tomala.dao.EspecialidadRepository;
import ec.edu.espe.examen.tomala.domain.Docente;
import ec.edu.espe.examen.tomala.domain.Especialidad;
import ec.edu.espe.examen.tomala.service.exception.CreacionException;
import jakarta.transaction.Transactional;

@Service
public class DocenteService {
    @Autowired

    private final DocenteRepository docenteRepository;
    private final EspecialidadRepository especialidadRepository;

    public DocenteService(DocenteRepository docenteRepository, EspecialidadRepository especialidadRepository) {
        this.docenteRepository = docenteRepository;
        this.especialidadRepository = especialidadRepository;
    }

    @Transactional
    public Docente create(Docente docente) {
        try {

            if (especialidadRepository.findById(docente.getCodEspecialidad()) != null) {
                Date fechaActual = new Date();
                if (docente.getFechaIngreso().after(fechaActual)) {
                    return this.docenteRepository.save(docente);

                } else {
                    throw new CreacionException("La fecha de ingreso debe ser mayor a la fecha actual");

                }

            }
            else{   
                throw new CreacionException("La especialidad no Existe");
            }
            
        } catch (Exception e) {
            throw new CreacionException("Ocurrio un error al crear el docente: " + docente.toString(), e);

        }
    }

}
