package ec.edu.espe.examen.tomala.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.examen.tomala.domain.Docente;
import ec.edu.espe.examen.tomala.domain.DocenteMateria;
import ec.edu.espe.examen.tomala.service.PlanificacionService;

@RestController
@RequestMapping("/planificacion")
public class PlanificacionController {
    @Autowired

    private PlanificacionService planificacionService;

    @PostMapping("/save")
    public ResponseEntity<DocenteMateria> Guardar(@RequestBody DocenteMateria docenteMateria) {
        System.out.println(docenteMateria.toString());
        return new ResponseEntity<>(planificacionService.create(docenteMateria), HttpStatus.OK);
    }

}
