package unam.diplomado.cajaahorro.transaccion.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "historico_estatus_transaccion")
public class HistoricoEstatusTransaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "historico_estatus_transaccion_id")
    private Integer id;

    private Date fecha;

    @JoinColumn(name = "estatus_transaccion_id")
    @ManyToOne
    private EstatusTransaccion estatusTransaccionId;

    @JoinColumn(name = "transaccion_id")
    @ManyToOne
    private Transaccion transaccionId;
}
