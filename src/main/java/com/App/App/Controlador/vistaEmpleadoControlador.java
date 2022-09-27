package com.App.App.Controlador;

import com.App.App.Entidades.Empleado;
import com.App.App.Servicios.EmpleadoServicio;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class vistaEmpleadoControlador {

    EmpleadoServicio servicio;

    public vistaEmpleadoControlador(EmpleadoServicio servicio) {
        this.servicio = servicio;
    }
/*
    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal){
        return "index";
    }*/

    @GetMapping("/Empleados")
    public String prueba (Model model){
        List<Empleado> lista=this.servicio.listarEmpleados();
        model.addAttribute("lista", lista);
        return "Empleados";
    }

    @GetMapping("/formEmpleado")
    public String mostrarFormulario(Model model){
        model.addAttribute("empleado", new Empleado());
        return "registrarEmpleado";
    }

    @PostMapping("/RegistrarEmpleado")
    public String agregarEmpleado(@ModelAttribute("empleado") Empleado empleado, Model model){
        model.addAttribute("empleado", servicio.crearEmpleado(empleado));
        return "redirect:/Empleados";
    }

    @GetMapping("/editarEmpleado/{doc}")
    public String pasarEmpleado(@PathVariable("doc") String documento, Model model){
        model.addAttribute("empleado", servicio.buscarEmpleado1(documento));
        return "editarEmpleado";
    }

    @GetMapping("/eliminarEmpleado/{doc}")
    public String eliminarEmpleado(@PathVariable("doc") String documento, Model model){
        servicio.eliminarEmpleado(documento);
        return "redirect:/Empleados";
    }

    @PostMapping("/guardarEditado/{doc}")
    public String actualizarEmpleado1(@PathVariable("doc") String documento, @ModelAttribute("empleado") Empleado empleado, Model model){
        Empleado emple = servicio.buscarEmpleado1(documento);
        emple.setNombreEmpleado(empleado.getNombreEmpleado());
        emple.setCorreo(empleado.getCorreo());
        emple.setPertenece_A_Empresa(empleado.getPertenece_A_Empresa());
        emple.setRol(empleado.getRol());
        servicio.actualizarEmpleado1(emple);
        return "redirect:/Empleados";
    }


}
