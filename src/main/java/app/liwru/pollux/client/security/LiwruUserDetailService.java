package app.liwru.pollux.client.security;

import app.liwru.pollux.client.service.UsuarioService;
import app.liwru.pollux.dto.UsuarioDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class LiwruUserDetailService implements UserDetailsService {


    private final UsuarioService usuarioService;

    public static Optional<UsuarioDTO> usuarioSession;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {



        Optional<UsuarioDTO> usuarioDTO= usuarioService.getUsuarioByEmail(username);
        usuarioSession=(usuarioDTO);

        if(usuarioDTO==null){
            throw new UsernameNotFoundException(username);
        }
        List<GrantedAuthority> roles = new ArrayList<>();

        roles.add(new SimpleGrantedAuthority( usuarioDTO.get().getRol().getDescripcion()));

        UserDetails ud= new User(usuarioDTO.get().getEmailUsuario(),usuarioDTO.get().getContrasena(),roles);
        return ud;
    }

}
