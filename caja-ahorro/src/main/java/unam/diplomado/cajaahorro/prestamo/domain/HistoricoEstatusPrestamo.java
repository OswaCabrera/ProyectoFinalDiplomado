package unam.diplomado.cajaahorro.prestamo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="historico_estatus_prestamos")
public class HistoricoEstatusPrestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "historico_estatus_prestamos_id")
    private Integer id;
    private Integer deuda;
    @Column(name = "fecha_actualizacion")
    private Date fechaActualizacion;
    @JoinColumn(name = "estatus_prestamos_id")
    @ManyToOne
    private EstatusPrestamo estatusPrestamoId;
    @JoinColumn(name = "prestamo_id")
    @ManyToOne
    private Prestamo prestamoId;
}
