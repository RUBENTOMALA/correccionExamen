package ec.edu.espe.examen.tomala.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.examen.tomala.domain.Especialidad;
import ec.edu.espe.examen.tomala.service.EspecialidadService;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/especialidad")
public class EspecialidadController {
    @Autowired
    private EspecialidadService especialidadService; 

    @GetMapping("/buscar-nombre/")
    public ResponseEntity<List<Especialidad>> buscar(@PathParam("nombre") String nombre) {
        return new ResponseEntity<>(especialidadService.buscarPatron(nombre), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Especialidad> Save(@RequestBody Especialidad especialidad) {
        return new ResponseEntity<>(especialidadService.create(especialidad), HttpStatus.OK);
    }

}
