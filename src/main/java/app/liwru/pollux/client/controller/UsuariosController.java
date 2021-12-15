package app.liwru.pollux.client.controller;

import app.liwru.pollux.client.service.RolService;
import app.liwru.pollux.client.service.TipoDocumentoService;
import app.liwru.pollux.client.service.UsuarioService;
import app.liwru.pollux.dto.UsuarioDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuariosController {

    private final UsuarioService usuarioService;
    private final TipoDocumentoService tipoDocumentoService;
    private  final RolService rolService;
    private final BCryptPasswordEncoder bcrypt;

    public UsuariosController(UsuarioService usuarioService, TipoDocumentoService tipoDocumentoService, RolService rolService, BCryptPasswordEncoder bcrypt) {
        this.usuarioService = usuarioService;
        this.tipoDocumentoService = tipoDocumentoService;
        this.rolService = rolService;
        this.bcrypt = bcrypt;
    }



    @GetMapping("/usuarios")
    public String usuarios(Model model) {
        usuarioService.getUsuarios().ifPresent(usuarios -> model.addAttribute("usuarios", usuarios));

        return "usuarios/index";
    }

    @PostMapping("/usuarios/save")
    public String usuariosSave(UsuarioDTO usuarioDTO) {

     //   usuarioDTO.setContrasena(bcrypt.encode(usuarioDTO.getContrasena()));
        usuarioService.updateUsuarios(usuarioDTO);
        return  "redirect:/usuarios";
    }

    @PostMapping("/usuarios/create/save")
    public String usuariosCreate(UsuarioDTO usuarioDTO) {
        usuarioDTO.setContrasena(bcrypt.encode(usuarioDTO.getContrasena()));
        usuarioDTO.setRol(null);
        usuarioDTO.setTipoDocumento(null);
        usuarioDTO.setEstado(1);
        usuarioService.createUsuarios(usuarioDTO);
        return  "redirect:/usuarios";
    }

    @GetMapping("/usuarios/create")
    public String EditarUsuario(Model model ) {
        model.addAttribute("usuario", new UsuarioDTO());
        tipoDocumentoService.getTipoDocumentos().ifPresent(tipoDocumentos -> model.addAttribute("tipoDocumentos",tipoDocumentos));
        rolService.getRoles().ifPresent(roles -> model.addAttribute("roles",roles));
        return "agregar/usuarios/index";
    }



    @GetMapping("/activarUsuario/{id}")
    public String activarUsuarios(@PathVariable Integer id) {
        usuarioService.activeUsuario(id);
        return "redirect:/usuarios";
    }

    @GetMapping("/desactivarUsuario/{id}")
    public String desactivarUsuarios(@PathVariable Integer id) {
        usuarioService.deactivateUsuario(id);
        return "redirect:/usuarios";
    }
}
