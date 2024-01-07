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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codDocente == null) ? 0 : codDocente.hashCode());
        result = prime * result + ((codMateria == null) ? 0 : codMateria.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DocenteMateriaPK other = (DocenteMateriaPK) obj;
        if (codDocente == null) {
            if (other.codDocente != null)
                return false;
        } else if (!codDocente.equals(other.codDocente))
            return false;
        if (codMateria == null) {
            if (other.codMateria != null)
                return false;
        } else if (!codMateria.equals(other.codMateria))
            return false;
        return true;
    }
    

    
    

}
