package app.liwru.pollux.client.controller;

import app.liwru.pollux.client.service.EmpresaService;
import app.liwru.pollux.dto.EmpresaDTO;
import app.liwru.pollux.dto.UsuarioDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RequestMapping("/ajustes")
@Controller
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping("/empresa")
    public String empresa(Model model)
    {
        empresaService.getEmpresas().ifPresent(empresas -> model.addAttribute("empresas", empresas));

        return "ajustes/empresa/index";
    }


    @GetMapping("editar/empresa/{id}")
    public String EditarEmpresa(Model model , @PathVariable Integer id) {
        empresaService.getEmpresa(id).ifPresent(empresas -> model.addAttribute("empresas",empresas));

        return "editar/empresa/index";
    }



    @PostMapping("/empresa/save")
    public String empresaSave(EmpresaDTO empresaDTO) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd ");
        empresaDTO.setUpdateAt(dtf.format(LocalDateTime.now()));
        empresaService.updateEmpresa(empresaDTO);
        return  "redirect:/ajustes/empresa";
    }

}
