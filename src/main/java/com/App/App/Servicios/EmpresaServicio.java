package com.App.App.Servicios;

import com.App.App.Entidades.Empresa;
import com.App.App.Entidades.MovimientoDinero;
import com.App.App.Repositorio.EmpresaRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.Optional;

@Service
public class EmpresaServicio {

    private EmpresaRepositorio repositorio;

    public EmpresaServicio(EmpresaRepositorio repositorio){
        this.repositorio = repositorio;
    }

    public ArrayList<Empresa> listarEmpresas(){

        return (ArrayList<Empresa>) repositorio.findAll();
    }

    public Optional<Empresa> buscarEmpresa(String NIT){

        return repositorio.findById(NIT);
    }

    public String crearEmpresa (Empresa empresa){
        if (!buscarEmpresa(empresa.getNIT()).isPresent()){
            repositorio.save(empresa);
            return "Empresa creada exitosamente.";
        }else{
            return "La empresa que intenta crear ya existe.";
        }
    }


    public String eliminarEmpresa(String NIT){
        if(buscarEmpresa(NIT).isPresent()){
            repositorio.deleteById(NIT);
            return "La empresa fue eliminada exitosamente.";
        }else{
            return "La empresa que intenta eliminar no existe.";
        }
    }

    public Empresa actualizarEmpresa(String NIT, Map<Object, Object> empresaMap) {

        Empresa empresa = repositorio.findById(NIT).get();
        empresaMap.forEach((key, value) -> {
            Field campo = ReflectionUtils.findField(Empresa.class, (String) key);
            campo.setAccessible(true);
            ReflectionUtils.setField(campo, empresa, value);
        });
        return repositorio.save(empresa);
    }
}

