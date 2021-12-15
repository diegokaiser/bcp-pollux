package app.liwru.pollux.client.controller;

import app.liwru.pollux.client.service.MotivosService;
import app.liwru.pollux.dto.MotivoDTO;
import app.liwru.pollux.dto.SedeDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@RequestMapping("/ajustes")
@Controller
public class MotivosController {

    private final MotivosService motivosService;

    public MotivosController(MotivosService motivosService) {
        this.motivosService = motivosService;
    }


    @GetMapping("/motivos")
    public String motivo(Model model)
    {
        motivosService.getMotivos().ifPresent(motivos -> model.addAttribute("motivos", motivos));

        return "ajustes/motivos/index";
    }

    @PostMapping("/motivos/save")
    public String motivosSave(MotivoDTO motivoDTO) {
        motivosService.updateMotivos(motivoDTO);
        return  "redirect:/ajustes/motivos";
    }

    @GetMapping("/motivos/create")
    public String crearMotivo(Model model) {
        model.addAttribute("motivo", new MotivoDTO());
        return "agregar/motivos/index";
    }
    @PostMapping("/motivos/create/save")
    public String crearMotivoSave( MotivoDTO motivo) {
        motivo.setEstadoMotivo(1);
        motivosService.createMotivos(motivo);
        return "redirect:/ajustes/motivos";
    }


    @GetMapping("/activarMotivos/{id}")
    public String activarMotivos(@PathVariable Integer id) {
        motivosService.activeMotivos(id);
        return "redirect:/ajustes/motivos";
    }

    @GetMapping("/desactivarMotivos/{id}")
    public String desactivaMotivos(@PathVariable Integer id) {
        motivosService.deactivateMotivos(id);
        return "redirect:/ajustes/motivos";
    }

}
