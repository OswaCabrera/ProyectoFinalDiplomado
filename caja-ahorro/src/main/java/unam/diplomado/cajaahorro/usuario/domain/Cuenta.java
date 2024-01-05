package unam.diplomado.cajaahorro.usuario.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Cuenta {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="cuenta_id")
    private Integer id;
    private Integer saldo;
    @Column(name="fecha_apertura")
    private Date fechaCreacion;

    @OneToOne(targetEntity=Usuario.class)
    @JoinColumn(name="usuario_id",nullable=false)
    private Usuario usuario;

    @ManyToOne(targetEntity=EstatusCuenta.class)
    @JoinColumn(name="estatus_cuenta_id",nullable=false)
    private EstatusCuenta estatusCuenta;

    public Cuenta(Integer saldo, Date fechaCreacion, Integer idEstatusCuenta) {
        this.saldo = saldo;
        this.fechaCreacion = fechaCreacion;
        this.estatusCuenta = new EstatusCuenta();
        this.estatusCuenta.setId(idEstatusCuenta);
    }
}
