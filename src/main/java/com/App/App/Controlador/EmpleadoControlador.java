package com.App.App.Controlador;

import com.App.App.Entidades.Empleado;
import com.App.App.Servicios.EmpleadoServicio;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

@RestController
public class EmpleadoControlador {

    private EmpleadoServicio servicio;

    public EmpleadoControlador(EmpleadoServicio servicio){

        this.servicio = servicio;
    }

    @GetMapping("/users")
    public ArrayList<Empleado> Listar(){

        return servicio.listarEmpleados();
    }

    @GetMapping("/users/{id}")
    public Optional<Empleado> buscarEmpleado(@PathVariable("id") String documento){
        return servicio.buscarEmpleado(documento);
    }

    @PostMapping("/users")
    public String crearEmpleado(@RequestBody Empleado empleado){
        return servicio.crearEmpleado(empleado);
    }

    @DeleteMapping("/users/{id}")
    public String eliminarEmpleado(@PathVariable("id") String documento){
        return servicio.eliminarEmpleado(documento);
    }

    @PatchMapping("users/{id}")
    public Empleado actualizarEmpleado(@PathVariable("id") String documento, @RequestBody Map<Object, Object> empleadoMap){
        return servicio.actualizarEmpleado(documento, empleadoMap);
    }
}
