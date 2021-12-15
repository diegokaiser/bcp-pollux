package app.liwru.pollux.client.controller;

import app.liwru.pollux.client.service.AgraviadosService;
import app.liwru.pollux.client.service.IncidenciaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class AgraviadosController {

    private final AgraviadosService agraviadosService;
    private final IncidenciaService incidenciaService;
    public AgraviadosController(AgraviadosService agraviadosService, IncidenciaService incidenciaService) {
        this.agraviadosService = agraviadosService;
        this.incidenciaService = incidenciaService;
    }

    @GetMapping("/agraviados")
    public String agraviados(Model model) {

        agraviadosService.getAgraviados().ifPresent(agraviados -> model.addAttribute("agraviados", agraviados));
      //  incidenciaService.getIncidencias().ifPresent(incidencias -> model.addAttribute("incidencias", incidencias));
        

        return "agraviados/index";
    }

}
