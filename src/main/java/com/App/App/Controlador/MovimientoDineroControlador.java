package com.App.App.Controlador;


import com.App.App.Entidades.MovimientoDinero;
import com.App.App.Servicios.MovimientoDineroServicio;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.spring5.expression.Mvc;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class MovimientoDineroControlador {

    private MovimientoDineroServicio servicio;

    public MovimientoDineroControlador(MovimientoDineroServicio servicio){
        this.servicio = servicio;
    }

    @GetMapping("/movements")
    public List<MovimientoDinero> listar(){
        return servicio.listarMovimientos();
    }

    @GetMapping("/enterpises/{id}/movements")
    public Optional<MovimientoDinero> buscarMovimiento(@PathVariable("id") int id){
        return servicio.buscarMovimiento(id);
    }

    @PostMapping("/movements")
    public String crearMovimiento(@RequestBody MovimientoDinero id){
        return servicio.crearMovimiento(id);
    }

    @DeleteMapping("/enterprises/{id}/movements")
    public String eliminarEmpleado(@PathVariable("id") int id){
        return servicio.eliminarMovimiento(id);
    }

    @PatchMapping("/enterprises/{id}/movements")
    public MovimientoDinero actualizarMovimiento(@PathVariable("id") int id, @RequestBody Map<Object, Object> movimientoMap){
        return servicio.actualizarMovimiento(id, movimientoMap);
    }
}
