package ec.edu.espe.examen.tomala.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ec.edu.espe.examen.tomala.dao.EspecialidadRepository;
import ec.edu.espe.examen.tomala.domain.Especialidad;
import ec.edu.espe.examen.tomala.service.exception.CreacionException;
import jakarta.transaction.Transactional;

@Service
public class EspecialidadService {
    private final EspecialidadRepository especialidadRepository;

    public EspecialidadService(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    public List<Especialidad> buscarPatron(String nombre) {
        try {
            List<Especialidad> especialidades = this.especialidadRepository.findByNombreContaining(nombre);
    
            if (especialidades == null || especialidades.isEmpty()) {
                throw new CreacionException("No se encontró ninguna especialidad que coincida con la búsqueda: " + nombre);
            }
    
            return especialidades;
        } catch (Exception e) {
            throw new CreacionException("Error al buscar especialidades por nombre: " + nombre, e);
        }
    }    

    @Transactional
    public Especialidad create(Especialidad especialidad) {
        try {
            return this.especialidadRepository.save(especialidad);
        } catch (Exception e) {
            throw new CreacionException("Ocurrio un error al crear la especialidad: " + especialidad.toString(), e);
        }
    }

}
