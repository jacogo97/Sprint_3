package com.App.App.Controlador;

import com.App.App.Entidades.Empresa;
import com.App.App.Servicios.EmpresaServicio;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.Optional;

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


    @PostMapping("/enterprises")
    public String crearEmpresa(@RequestBody Empresa empresa){

        return servicio.crearEmpresa(empresa);
    }

    @GetMapping("enterprises/{id}")
    public Optional<Empresa> buscarEmpresa (@PathVariable("id") String NIT ){

        return servicio.buscarEmpresa(NIT);
    }

    @DeleteMapping("/enterprises/{id}")
    public String eliminarEmpresa(@PathVariable("id") String NIT){

        return servicio.eliminarEmpresa(NIT);
    }

    @PatchMapping("/enterprises/{id}")
    public Empresa actualizarEmpresa(@PathVariable("id") String NIT, @RequestBody Map<Object, Object> empresaMap){
       return servicio.actualizarEmpresa(NIT, empresaMap);
    }





}
