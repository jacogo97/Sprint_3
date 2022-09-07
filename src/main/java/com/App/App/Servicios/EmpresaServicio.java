package com.App.App.Servicios;

import com.App.App.Entidades.Empresa;
import com.App.App.Repositorio.EmpresaRepositorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmpresaServicio {

    private EmpresaRepositorio repositorio;

    public EmpresaServicio(EmpresaRepositorio repositorio){
        this.repositorio = repositorio;
    }

    public ArrayList<Empresa> listarEmpresas(){
        return (ArrayList<Empresa>) repositorio.findAll();
    }
}
