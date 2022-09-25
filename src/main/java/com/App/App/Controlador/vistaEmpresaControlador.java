package com.App.App.Controlador;

import com.App.App.Entidades.Empresa;
import com.App.App.Servicios.EmpresaServicio;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class vistaEmpresaControlador {

    EmpresaServicio servicio;

    public vistaEmpresaControlador(EmpresaServicio servicio){
        this.servicio = servicio;
    }

    @GetMapping("/Empresas")
    public String prueba (Model model){
        List<Empresa> lista=this.servicio.listarEmpresas();
        model.addAttribute("lista", lista);
        return "Empresas";
    }

    @GetMapping("/formEmpresa")
    public String mostrarFormulario(Model model){
        model.addAttribute("empresa", new Empresa());
        return "registrarEmpresa";
    }

    @PostMapping("/RegistrarEmpresa")
    public String agregarEmpresa(@ModelAttribute("empresa") Empresa empresa, Model model){
        model.addAttribute("empresa", servicio.crearEmpresa(empresa));
        return "redirect:/Empresas";
    }

    @GetMapping("/editarEmpresa/{NIT}")
    public String pasarEmpresa(@PathVariable("NIT") String NIT, Model model){
            model.addAttribute("empresa", servicio.buscarEmpresa1(NIT));
            return "editarEmpresa";
    }

    @GetMapping("/eliminarEmpresa/{NIT}")
    public String eliminarEmpresa(@PathVariable("NIT") String NIT, Model model) {
            servicio.eliminarEmpresa(NIT);
            return "redirect:/Empresas";
    }

    @PostMapping("/guardarEditado/{nit}")
        public String actualizarEmpresa1(@PathVariable("nit") String NIT, @ModelAttribute("empresa") Empresa empresa, Model model){
        Empresa emp = servicio.buscarEmpresa1(NIT);
        emp.setNombreEmpresa(empresa.getNombreEmpresa());
        emp.setDireccion(empresa.getDireccion());
        emp.setTelefono(empresa.getTelefono());
        servicio.actualizarEmpresa1(emp);
        return "redirect:/Empresas";

    }




}
