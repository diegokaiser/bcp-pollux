package app.liwru.pollux.client.controller;

import app.liwru.pollux.client.service.EstadoService;
import app.liwru.pollux.dto.EstadoDTO;
import app.liwru.pollux.dto.UsuarioDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/ajustes")
@Controller
public class EstadoController {

    private final EstadoService estadoService;

    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }


    @GetMapping("/estados")
    public String motivo(Model model)
    {
        estadoService.getEstados().ifPresent(estados -> model.addAttribute("estados", estados));

        return "ajustes/estados/index";
    }


    @GetMapping("/estados/create")
    public String CreateEstado(Model model ) {
        model.addAttribute("estado", new EstadoDTO());
        return "agregar/estados/index";
    }

    @PostMapping("/estados/create/save")
    public String CreateEstadoSave(EstadoDTO estadoDTO) {
        estadoService.createEstado(estadoDTO);
        return  "redirect:/ajustes/estados";
    }
}
