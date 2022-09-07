package com.App.App.Entidades;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Calendar;

@Entity
@Table(name = "Empleados")
public class Empleado {

    @Id
    @Column(nullable = false)
    private String nombreEmpleado;
    @Column(nullable = false)
    private String correo;
    @ManyToOne
    @JoinColumn(name = "NIT")
    private Empresa empresa;
    @Column(nullable = false)
    private String rol;
    @OneToOne
    @JoinColumn(name = "empleado")
    private MovimientoDinero[] movimiento;
    @Column(nullable = false)
    private Calendar updatedAt;


    public Empleado() {
    }


    public Empleado(String nombreEmpleado, String correo, Empresa empresa, String rol, MovimientoDinero[] movimiento, Calendar updatedAt) {
        this.nombreEmpleado = nombreEmpleado;
        this.correo = correo;
        this.empresa = empresa;
        this.rol = rol;
        this.movimiento = movimiento;
        this.updatedAt = updatedAt;
    }


    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
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
        return "Empleado{" +
                "nombreEmpleado='" + nombreEmpleado + '\'' +
                ", correo='" + correo + '\'' +
                ", empresa=" + empresa +
                ", rol='" + rol + '\'' +
                ", movimiento=" + Arrays.toString(movimiento) +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
