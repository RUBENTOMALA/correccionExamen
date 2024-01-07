package ec.edu.espe.examen.tomala.controller;

import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.examen.tomala.domain.Docente;
import ec.edu.espe.examen.tomala.service.DocenteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/docente")
public class DocenteController {
    @Autowired
    private DocenteService docenteService;

    @PostMapping("/save")
    public ResponseEntity<Docente> Guardar (@RequestBody Docente docente) {
        System.out.println(docente.toString());
        return new ResponseEntity<>(docenteService.create(docente), HttpStatus.OK);
    }


}
