package unam.diplomado.cajaahorro.transaccion.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="tipo_transaccion")
public class TipoTransaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_transaccion_id")
    private Integer id;
    private String nombre;
    private String descripcion;
}
