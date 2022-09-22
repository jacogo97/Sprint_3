package com.App.App.Servicios;

import com.App.App.Entidades.Empleado;
import com.App.App.Entidades.MovimientoDinero;
import com.App.App.Repositorio.EmpleadoRepositorio;
import com.App.App.Repositorio.EmpresaRepositorio;
import com.App.App.Repositorio.MovimientoDineroRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MovimientoDineroServicio {

    private MovimientoDineroRepositorio repositorio;

    public MovimientoDineroServicio(MovimientoDineroRepositorio repositorio){
        this.repositorio = repositorio;
    }
/*
    private MovimientoDineroRepositorio MovRepo;
    private EmpresaRepositorio EmpresaRepo;
    private EmpleadoRepositorio EmpleadoRepo;

    private MovimientoDineroServicio(MovimientoDineroRepositorio repositorio){
        this.MovRepo = MovRepo;
        this.EmpresaRepo = EmpresaRepo;
        this.EmpleadoRepo = EmpleadoRepo;
    }


    public MovimientoDinero agregarMovimiento(String NIT, String documento, MovimientoDinero movi){
        EmpleadoRepo.findById(documento).map(doc -> {
            movi.setDocumento(doc);
            return doc;
        });
        return EmpresaRepo.findById(NIT).map(Empre ->{
            movi.setEmpresa(Empre);
            return MovRepo.save(movi);
        }).get();
    }*/


    /*public ArrayList<MovimientoDinero> listarMovimientos(){
        return (ArrayList<MovimientoDinero>) repositorio.findAll();
    }*/
    public List<MovimientoDinero> listarMovimientos(){
        return (List<MovimientoDinero>) repositorio.findAll();}

    public Optional<MovimientoDinero> buscarMovimiento(int id){

        return repositorio.findById(id);
    }

    public String crearMovimiento (MovimientoDinero movimiento){
        if(!buscarMovimiento(movimiento.getId()).isPresent()){
            repositorio.save(movimiento);
            return "El nuevo movimiento ha sido creado exitosamente";
        }else{
            return "El movimiento que intenta crear ya existe";
        }
    }

    public String eliminarMovimiento(int movimiento){
        if(buscarMovimiento(movimiento).isPresent()){
            repositorio.deleteById(movimiento);
            return "El movimiento fue eliminado correctamente.";
        }else{
            return "El movimiento que intenta eliminar no existe";
        }
    }

    public MovimientoDinero actualizarMovimiento(int id, Map<Object, Object> movimientoMap){
        MovimientoDinero movimiento = (MovimientoDinero) repositorio.findById(id).get();
        movimientoMap.forEach((key, value)->{
            Field campo = ReflectionUtils.findField(MovimientoDinero.class, (String) key);
            campo.setAccessible(true);
            ReflectionUtils.setField(campo, movimiento, value);
        });
        return repositorio.save(movimiento);
    }

}
