package unam.diplomado.cajaahorro.transaccion.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import unam.diplomado.cajaahorro.prestamo.domain.Prestamo;
import unam.diplomado.cajaahorro.prestamo.service.PrestamoService;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "transaccion_pago_prestamo")
@DiscriminatorValue("2")
public class TransaccionPagoPrestamo extends Transaccion{

    @JoinColumn(name = "prestamo_id")
    @ManyToOne(targetEntity = Prestamo.class)
    private Prestamo prestamoId;

    //String with parent
    public String toString() {
        return "TransaccionPagoPrestamo(super=" + super.toString() + ", prestamoId=" + this.getPrestamoId() + ")";
    }
}
