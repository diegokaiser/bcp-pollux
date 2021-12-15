package app.liwru.pollux.client.controller;

import app.liwru.pollux.client.service.EmpresaService;
import app.liwru.pollux.client.service.SedeService;
import app.liwru.pollux.dto.SedeDTO;
import app.liwru.pollux.dto.UsuarioDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Slf4j
@Controller
public class SedeController {

    private final SedeService sedeService;
    private final EmpresaService empresaService;

    public SedeController(SedeService sedeService, EmpresaService empresaService) {
        this.sedeService = sedeService;
        this.empresaService = empresaService;
    }


    @GetMapping("ajustes/sedes")
    public String sede(Model model)
    {
        sedeService.getSedes().ifPresent(sedes -> model.addAttribute("sedes", sedes));

        return "ajustes/sedes/index";
    }

    @PostMapping("ajustes/sede/save")
    public String sedeSave(SedeDTO sedeDTO) {
        log.info("GHola");
        sedeService.updateSede(sedeDTO);
        return  "redirect:/ajustes/sedes";
    }

    @PostMapping("ajustes/sede/create/save")
    public String sedeCreate(SedeDTO sedeDTO) {
        LocalDate date = LocalDate.now();
        sedeDTO.setCreatedAt(date);
        sedeService.createSedes(sedeDTO);
        return "redirect:/ajustes/sedes";
    }

    @GetMapping("ajustes/sede/create")
    public String EditarSede(Model model) {
        model.addAttribute("sede", new SedeDTO());
        empresaService.getEmpresas().ifPresent(empresa -> model.addAttribute("empresa",empresa));
        return "agregar/sedes/index";
    }


    @GetMapping("ajustes/activarSede/{id}")
    public String activarSedes(@PathVariable Integer id) {
        sedeService.activeSede(id);
        return "redirect:/ajustes/sedes";
    }

    @GetMapping("ajustes/desactivarSede/{id}")
    public String desactivarSedes(@PathVariable Integer id) {
        sedeService.deactivateSede(id);
        return "redirect:/ajustes/sedes";
    }

}
