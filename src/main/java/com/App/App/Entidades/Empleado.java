package com.App.App.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Empleados")
public class Empleado {

    @Id
    @Column(nullable = false)
    private String documento;
    @Column(nullable = false)
    private String nombreEmpleado;
    @Column(nullable = false)
    private String correo;
    @ManyToOne//(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "NIT", referencedColumnName = "NIT", nullable = true)
    private Empresa Pertenece_A_Empresa;
    @Column(nullable = false)
    private Rol rol;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date updatedAt;


    @PrePersist
    public void prePersist(){
        this.updatedAt = new Date();
    }


    public Empleado() {
    }

    public Empleado(String documento, String nombreEmpleado, String correo, Empresa pertenece_A_Empresa, Rol rol, Date updatedAt) {
        this.documento = documento;
        this.nombreEmpleado = nombreEmpleado;
        this.correo = correo;
        this.Pertenece_A_Empresa = pertenece_A_Empresa;
        this.rol = rol;
        this.updatedAt = updatedAt;
    }


    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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

    public Empresa getPertenece_A_Empresa() {
        return Pertenece_A_Empresa;
    }

    public void setPertenece_A_Empresa(Empresa pertenece_A_Empresa) {
        this.Pertenece_A_Empresa = pertenece_A_Empresa;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


    @Override
    public String toString() {
        return "Empleado{" +
                "documento='" + documento + '\'' +
                ", nombreEmpleado='" + nombreEmpleado + '\'' +
                ", correo='" + correo + '\'' +
                ", Pertenece_A_Empresa=" + Pertenece_A_Empresa +
                ", rol=" + rol +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
