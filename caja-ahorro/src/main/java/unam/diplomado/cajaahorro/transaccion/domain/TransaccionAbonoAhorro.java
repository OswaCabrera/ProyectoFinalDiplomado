package unam.diplomado.cajaahorro.transaccion.domain;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "transaccion_abono_ahorro")
@DiscriminatorValue("1")
public class TransaccionAbonoAhorro extends Transaccion{
    @Column(name = "dias_atraso")
    private Integer diasAtraso;


    //ToString with the parent attributes
    @Override
    public String toString() {
        return "TransaccionAbonoAhorro{" +
                "dias_atraso=" + diasAtraso +
                "} " + super.toString();
    }
}
