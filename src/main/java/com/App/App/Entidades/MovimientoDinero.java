package com.App.App.Entidades;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MovimientoDeDinero")
public class MovimientoDinero {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
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
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date updatedAt;

    @PrePersist
    public void prePersist(){
        this.updatedAt = new Date();
    }

    public MovimientoDinero() {
    }

    public MovimientoDinero(String id, double monto, String concepto, Empleado empleado, Empresa empresa, Date updatedAt) {
        this.id = id;
        this.monto = monto;
        this.concepto = concepto;
        this.empleado = empleado;
        this.empresa = empresa;
        this.updatedAt = updatedAt;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


    @Override
    public String toString() {
        return "MovimientoDinero{" +
                "id='" + id + '\'' +
                ", monto=" + monto +
                ", concepto='" + concepto + '\'' +
                ", empleado=" + empleado +
                ", empresa=" + empresa +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
