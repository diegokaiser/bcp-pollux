package app.liwru.pollux.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DetallesController {

    @GetMapping("/detalles/agraviado")
    public String DetallesAgraviado() {
        return "detalles/agraviado/index";
    }

    @GetMapping("/detalles/usuario")
    public String DetallesUsuario() {
        return "detalles/usuario/index";
    }

    @GetMapping("/detalles/incidencia")
    public String DetallesIncidencia() {
        return "detalles/incidencia/index";
    }

    @GetMapping("/detalles/sede")
    public String DetallesSede() {return "detalles/sede/index"; }
}
