package app.liwru.pollux.client.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import app.liwru.pollux.client.security.LiwruUserDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import app.liwru.pollux.dto.UsuarioDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Slf4j
@Controller
//@CrossOrigin
public class LoginController {
    String password;
    @GetMapping("/login")
    public String login(ModelMap model){

        log.info("hola");
        log.info(password+"1");
        model.addAttribute("password",password);
        log.info(password+ "2");
        return "login/index";
    }





    @GetMapping("/logout")
    public String logout(){
        return "login/index";
    }





/*    @PostMapping("/")
    public UsuarioDTO login(@RequestParam("emailUsuario") String emailUsuario,
                            @RequestParam("numeroDocUsuario") String numeroDocUsuario) {
        String token = getJWTToken(emailUsuario);
        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setEmailUsuario(emailUsuario);
        usuario.setToken(token);
        return usuario;
    }

    private String getJWTToken(String emailUsuario) {
        String secretKey = "secretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(emailUsuario)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();
        return "Bearer " + token;
    }*/
}
