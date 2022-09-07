package com.App.App.Controlador;

import com.App.App.Entidades.Empresa;
import com.App.App.Servicios.EmpresaServicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class EmpresaControlador {

    private EmpresaServicio servicio;

    public EmpresaControlador(EmpresaServicio servicio){
        this.servicio = servicio;
    }

    @GetMapping("/enterprises")
    public ArrayList<Empresa> Listar(){
        return servicio.listarEmpresas();
    }





}
