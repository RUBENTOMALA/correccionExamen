package ec.edu.espe.examen.tomala.domain;

import java.io.Serializable;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class DocenteMateriaPK implements Serializable {

    @Column(name = "COD_DOCENTE", nullable = false)
    private Integer codDocente;
    @Column(name = "COD_MATERIA", nullable = false)
    private Integer codMateria;

    public DocenteMateriaPK() {
    }

    public DocenteMateriaPK(Integer codDocente, Integer codMateria) {
        this.codDocente = codDocente;
        this.codMateria = codMateria;
    }

    @Override
    public String toString() {
        return "DocenteMateriaPK [codDocente=" + codDocente + ", codMateria=" + codMateria + "]";
    }

    
    

}
