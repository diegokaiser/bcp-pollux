package app.liwru.pollux.client.controller;

import app.liwru.pollux.client.service.DocumentoService;
import app.liwru.pollux.dto.MotivoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DocumentosController {

    private final DocumentoService documentoService;

    public DocumentosController(DocumentoService documentoService) {
        this.documentoService = documentoService;
    }



    @GetMapping("/documentos/{id}")
    public String documento(Model model,@PathVariable Integer id)
    {
        documentoService.getDocumentosByIdIncidencia(id).ifPresent(documentos -> model.addAttribute("documentos", documentos));

        return "ajustes/documentos/index";
    }



}
