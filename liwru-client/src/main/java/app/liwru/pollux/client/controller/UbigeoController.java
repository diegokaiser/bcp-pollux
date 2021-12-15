package app.liwru.pollux.client.controller;

import app.liwru.pollux.client.service.DepartamentoService;
import app.liwru.pollux.dto.DepartamentoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UbigeoController {

   private final DepartamentoService departamentoService;

    public UbigeoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }


    @GetMapping("/ubigeo")
    public String ubigeo(Model model) {
        departamentoService.getDepartamentos().ifPresent(departamentos -> model.addAttribute("departamentos", departamentos));

        return "ubigeo/departamento/index";
    }





    @GetMapping("/ubigeo/distrito")
    public String distrito() {
        return "ubigeo/distrito/index";
    }

    @GetMapping("/ubigeo/provincia")
    public String provincia() {
        return "ubigeo/provincia/index";
    }

    @GetMapping("/ubigeo/departamento")
    public String departamento() {
        return "ubigeo/departamento/index";
    }


}