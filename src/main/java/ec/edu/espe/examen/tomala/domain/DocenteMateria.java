package ec.edu.espe.examen.tomala.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "DOCENTE_MATERIA")
public class DocenteMateria {
    @EmbeddedId
    private DocenteMateriaPK PK;

    @Column(name = "PERIODO", nullable = false, length = 10)
    private String periodo;

    @Column(name = "ALUMNOS_MATRICULADOS", nullable = false)
    private Integer alumnosMatriculados;

    @Column(name = "ESTADO", nullable = false, length = 3)
    private String estado;

    @Column(name = "PROMEDIO_CURSO", nullable = false, precision = 4, scale = 2)
    private BigDecimal promedioCurso;

    @Column(name = "FECHA_ULTIMO_CAMBIO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechaUltimoCambio;
    
    @Version
    private Long version;

    public DocenteMateria() {
    }

    public DocenteMateria(DocenteMateriaPK pK) {
        PK = pK;
    }

    
    @Override
    public String toString() {
        return "DocenteMateria [PK=" + PK + ", periodo=" + periodo + ", alumnosMatriculados=" + alumnosMatriculados
                + ", estado=" + estado + ", promedioCurso=" + promedioCurso + ", fechaUltimoCambio=" + fechaUltimoCambio
                + ", version=" + version + "]";
    }

    

}
