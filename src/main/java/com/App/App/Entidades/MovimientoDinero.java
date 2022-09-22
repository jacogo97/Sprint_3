package com.App.App.Entidades;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "MovimientoDinero")
public class MovimientoDinero {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private double monto;
    @Column(nullable = false)
    private String concepto;
    @OneToOne//(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "documento", referencedColumnName = "documento", nullable = true)
    private Empleado Doc_Empleado;
    @OneToOne//(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "NIT", referencedColumnName = "NIT", nullable = true)
    private Empresa NIT_Empresa;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date updatedAt;

    @PrePersist
    public void prePersist(){
        this.updatedAt = new Date();
    }

    public MovimientoDinero() {
    }

    public MovimientoDinero(int id, double monto, String concepto, Empleado doc_Empleado, Empresa NIT_Empresa, Date updatedAt) {
        this.id = id;
        this.monto = monto;
        this.concepto = concepto;
        this.Doc_Empleado = doc_Empleado;
        this.NIT_Empresa = NIT_Empresa;
        this.updatedAt = updatedAt;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Empleado getDoc_Empleado() {
        return Doc_Empleado;
    }

    public void setDoc_Empleado(Empleado doc_Empleado) {
        this.Doc_Empleado = doc_Empleado;
    }

    public Empresa getNIT_Empresa() {
        return NIT_Empresa;
    }

    public void setNIT_Empresa(Empresa NIT_Empresa) {
        this.NIT_Empresa = NIT_Empresa;
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
                "id=" + id +
                ", monto=" + monto +
                ", concepto='" + concepto + '\'' +
                ", Doc_Empleado=" + Doc_Empleado +
                ", NIT_Empresa=" + NIT_Empresa +
                ", updatedAt=" + updatedAt +
                '}';
    }
}

