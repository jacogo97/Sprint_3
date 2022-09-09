package com.App.App.Servicios;

import com.App.App.Entidades.Empleado;
import com.App.App.Repositorio.EmpleadoRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

@Service
public class EmpleadoServicio {
    private EmpleadoRepositorio repositorio;

    public EmpleadoServicio(EmpleadoRepositorio repositorio){

        this.repositorio = repositorio;
    }


    public ArrayList<Empleado> listarEmpleados(){

        return (ArrayList<Empleado>) repositorio.findAll();
    }

    public Optional<Empleado> buscarEmpleado(String documento){

        return repositorio.findById(documento);
    }

    public String crearEmpleado (Empleado empleado){
        if(!buscarEmpleado(empleado.getDocumento()).isPresent()){
            repositorio.save(empleado);
            return "El nuevo empleado ha sido creado exitosamente.";
        }else{
            return "El Empleado que intenta crear ya existe.";
        }
    }

    public String eliminarEmpleado(String documento){
        if(buscarEmpleado(documento).isPresent()){
            repositorio.deleteById(documento);
            return "El Empleado fue eliminado exitosamente.";
        }else{
            return "El Empleado que intenta eliminar no existe.";
        }
    }

    public Empleado actualizarEmpleado(String documento, Map<Object, Object> empleadoMap){

        Empleado empleado = repositorio.findById(documento).get();
        empleadoMap.forEach((key, value)->{
            Field campo = ReflectionUtils.findField(Empleado.class, (String) key);
            campo.setAccessible(true);
            ReflectionUtils.setField(campo, empleado, value);
        });
        return repositorio.save(empleado);
    }



}
