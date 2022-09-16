package com.App.App.Entidades;

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
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "NIT", referencedColumnName = "NIT", nullable = true)
    private Empresa empresa;
    @Column(nullable = false)
    private Rol rol;
    @OneToOne
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = true)
    private MovimientoDinero movimiento;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date updatedAt;


    @PrePersist
    public void prePersist(){
        this.updatedAt = new Date();
    }

    /*@OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<MovimientoDinero> movimientos;*/


    public Empleado() {
    }

    public Empleado(String documento, String nombreEmpleado, String correo, Empresa empresa, Rol rol, MovimientoDinero movimiento, Date updatedAt, Set<MovimientoDinero> movimientos) {
        this.documento = documento;
        this.nombreEmpleado = nombreEmpleado;
        this.correo = correo;
        this.empresa = empresa;
        this.rol = rol;
        this.movimiento = movimiento;
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
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
        return "Empleado{" +
                "documento='" + documento + '\'' +
                ", nombreEmpleado='" + nombreEmpleado + '\'' +
                ", correo='" + correo + '\'' +
                ", empresa=" + empresa +
                ", rol=" + rol +
                ", movimiento=" + movimiento +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
