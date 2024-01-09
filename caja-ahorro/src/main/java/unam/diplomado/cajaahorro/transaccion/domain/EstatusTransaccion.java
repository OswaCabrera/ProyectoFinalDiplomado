package unam.diplomado.cajaahorro.transaccion.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="estatus_transaccion")
public class EstatusTransaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estatus_transaccion_id")
    private Integer id;
    private String nombre;
    private String descripcion;
}
