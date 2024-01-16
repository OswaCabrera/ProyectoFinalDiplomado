package unam.diplomado.cajaahorro.transaccion.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import unam.diplomado.cajaahorro.usuario.domain.Cuenta;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_transaccion_id",
        discriminatorType = DiscriminatorType.INTEGER)
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaccion_id")
    private Integer id;
    @Min(value = 0, message = "El monto debe ser mayor a 0")
    private Integer monto;
    private Date fecha;
    private String comprobante;
    @JoinColumn(name = "tipo_transaccion_id", insertable=false, updatable=false)
    @ManyToOne
    private TipoTransaccion tipoTransaccionId;

    @JoinColumn(name = "estatus_transaccion_id")
    @ManyToOne
    private EstatusTransaccion estatusTransaccionId;

    @JoinColumn(name = "cuenta_id")
    @ManyToOne
    private Cuenta cuentaId;
}
