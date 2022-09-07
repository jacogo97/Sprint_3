package com.App.App.Entidades;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "MovimientoDeDinero")
public class MovimientoDinero {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private double monto;
    @Column(nullable = false)
    private String concepto;
    @ManyToOne
    @JoinColumn(name = "nombreEmpleado")
    private Empleado empleado;
    @ManyToOne
    @JoinColumn(name = "NIT")
    private Empresa empresa;
    @Column(nullable = false)
    private Calendar updatedAt;
}
