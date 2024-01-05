package unam.diplomado.cajaahorro.prestamo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="estatus_prestamos")
public class EstatusPrestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estatus_prestamos_id")
    private Integer id;
    private String nombre;
    private String descripcion;
}
