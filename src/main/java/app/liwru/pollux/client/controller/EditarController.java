package app.liwru.pollux.client.controller;

import app.liwru.pollux.client.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EditarController {

    private final AgraviadosService agraviadosService;
    private final TipoDocumentoService tipoDocumentoService;
    private final IncidenciaService incidenciaService;
    private final UsuarioService usuarioService;
    private final RolService rolService;
    private final SedeService sedeService;
    private final EmpresaService empresaService;
    private final MotivosService motivosService;

    public EditarController(AgraviadosService agraviadosService, TipoDocumentoService tipoDocumentoService, IncidenciaService incidenciaService, UsuarioService usuarioService, RolService rolService, SedeService sedeService, EmpresaService empresaService, MotivosService motivosService) {
        this.agraviadosService = agraviadosService;
        this.tipoDocumentoService = tipoDocumentoService;
        this.incidenciaService = incidenciaService;
        this.usuarioService = usuarioService;
        this.rolService = rolService;
        this.sedeService = sedeService;
        this.empresaService = empresaService;
        this.motivosService = motivosService;
    }

    @GetMapping("/editar/agraviado/{id}")
    public String EditarAgraviado(Model model , @PathVariable Integer id) {
        agraviadosService.getAgraviado(id).ifPresent(agraviado -> model.addAttribute("agraviado",agraviado));
        incidenciaService.getIncidenciasPorAgraviado(id).ifPresent(incidenciasAgraviados -> model.addAttribute("incidenciasAgraviados",incidenciasAgraviados));
        tipoDocumentoService.getTipoDocumentos().ifPresent(tipoDocumentos -> model.addAttribute("tipoDocumentos",tipoDocumentos));
        return "editar/agraviado/index";
    }


    @GetMapping("editar/usuario/{id}")
    public String EditarUsuario(Model model , @PathVariable Integer id) {
        usuarioService.getUsuario(id).ifPresent(usuario -> model.addAttribute("usuario",usuario));
        tipoDocumentoService.getTipoDocumentos().ifPresent(tipoDocumentos -> model.addAttribute("tipoDocumentos",tipoDocumentos));
        rolService.getRoles().ifPresent(roles -> model.addAttribute("roles",roles));
        return "editar/usuario/index";
    }

    @GetMapping("/editar/incidencia")
    public String EditarIncidencia() {
        return "editar/incidencia/index";
    }



    @GetMapping("ajustes/editar/sede/{id}")
    public String EditarSede(Model model,@PathVariable Integer id) {
        sedeService.getSede(id).ifPresent(sede -> model.addAttribute("sede",sede));
        empresaService.getEmpresas().ifPresent(empresa -> model.addAttribute("empresa",empresa));
        return "editar/sede/index";
    }

    @GetMapping("ajustes/editar/motivo/{id}")
    public String EditarMotivo(Model model,@PathVariable Integer id) {
        motivosService.getMotivo(id).ifPresent(motivo -> model.addAttribute("motivo",motivo));
        return "editar/motivos/index";
    }


}
