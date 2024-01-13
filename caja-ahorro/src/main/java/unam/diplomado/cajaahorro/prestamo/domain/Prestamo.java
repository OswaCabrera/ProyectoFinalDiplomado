package unam.diplomado.cajaahorro.prestamo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import unam.diplomado.cajaahorro.usuario.domain.Usuario;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prestamo_id")
    private Integer id;
    @Column(name = "monto_original")
    private Integer montoOriginal;
    @Column(name = "monto_pagar")
    private Integer montoPagar;
    @Column(name = "cantidad_pagada")
    private Integer cantidadPagada;
    private Integer mensualidades;
    private Integer interes;
    @Column(name = "fecha_peticion")
    private Date fechaPeticion;
    @JoinColumn(name = "estatus_prestamos_id")
    @ManyToOne
    private EstatusPrestamo estatusPrestamoId;

    @JoinColumn(name = "usuario_id")
    @ManyToOne
    private Usuario usuarioId;
}
