package com.App.App.Entidades;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Calendar;

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
    @OneToOne
    @JoinColumn(name = "empresa")
    private MovimientoDinero[] movimiento;
    @Column(nullable = false)
    private Calendar updatedAt;


    public Empresa() {
    }


    public Empresa(String NIT, String nombreEmpresa, String direccion, String telefono, MovimientoDinero[] movimiento, Calendar updatedAt) {
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

    public MovimientoDinero[] getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(MovimientoDinero[] movimiento) {
        this.movimiento = movimiento;
    }

    public Calendar getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Calendar updatedAt) {
        this.updatedAt = updatedAt;
    }


    @Override
    public String toString() {
        return "Empresa{" +
                "NIT='" + NIT + '\'' +
                ", nombreEmpresa='" + nombreEmpresa + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", movimiento=" + Arrays.toString(movimiento) +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
