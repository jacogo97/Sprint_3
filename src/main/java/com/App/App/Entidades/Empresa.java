package com.App.App.Entidades;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "Empresas")
public class Empresa {

    @Id
    @Column(nullable = false)
    private String NIT;
    @Column(unique = true)
    private String nombreEmpresa;
    @Column(nullable = false)
    private String direccion;
    @Column(nullable = false)
    private String telefono;
    //@OneToOne
    @ManyToOne
    @JoinColumn(name = "empresa")
    private MovimientoDinero movimiento;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date updatedAt;

    @PrePersist()
    public void prePersist(){
        this.updatedAt = new Date();
    }


    public Empresa() {
    }

    public Empresa(String NIT, String nombreEmpresa, String direccion, String telefono, MovimientoDinero movimiento, Date updatedAt) {
        this.NIT = NIT;
        this.nombreEmpresa = nombreEmpresa;
        this.direccion = direccion;
        this.telefono = telefono;
        this.movimiento = movimiento;
        this.updatedAt = updatedAt;
    }


    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public MovimientoDinero getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(MovimientoDinero movimiento) {
        this.movimiento = movimiento;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


    @Override
    public String toString() {
        return "Empresa{" +
                "NIT='" + NIT + '\'' +
                ", nombreEmpresa='" + nombreEmpresa + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", movimiento=" + movimiento +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
