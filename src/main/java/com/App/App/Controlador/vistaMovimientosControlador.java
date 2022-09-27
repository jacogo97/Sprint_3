package com.App.App.Controlador;

import com.App.App.Entidades.Empleado;
import com.App.App.Entidades.MovimientoDinero;
import com.App.App.Servicios.MovimientoDineroServicio;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class vistaMovimientosControlador {

    MovimientoDineroServicio servicio;

    public vistaMovimientosControlador(MovimientoDineroServicio servicio) {
        this.servicio = servicio;
    }
/*
    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal){
        return "index";
    }*/

    @GetMapping("/Movimientos")
    public String prueba (Model model){
        List<MovimientoDinero> lista=this.servicio.listarMovimientos();
        model.addAttribute("lista", lista);
        return "Movimientos";
    }
}
