package app.liwru.pollux.client.service;

import app.liwru.pollux.dto.IncidenciaDTO;
import app.liwru.pollux.dto.UsuarioDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Configuration
@Slf4j
@Service
public class UsuarioService {

    //private static final String PRODUCT_ENDPOINT = "https://liwru-pollux-apis.herokuapp.com/api/usuarios";
   private static final String USUARIOS_ENDPOINT = "http://localhost:9000/api/usuarios";
    private static final String USUARIOS_LOGIC_ACTIVE_ENDPOINT = "http://localhost:9000/api/usuarios/activeUsuario";
    private static final String USUARIOS_LOGIC_DELETE_ENDPOINT = "http://localhost:9000/api/usuarios/deleteUsuario";
    private static final String USUARIOS_POR_ROL_ENDPOINT = "http://localhost:9000/api/usuarios/usuarioPorRol";
    private static final String USUARIOS_POR_EMAIL =  "http://localhost:9000/api/usuarios/email";




    private final RestTemplate restTemplate;

    public UsuarioService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Optional<List<UsuarioDTO>> getUsuarios() {

        List<UsuarioDTO> usuarios = null;
        ResponseEntity<UsuarioDTO[]> usuarioResponse = restTemplate.getForEntity(USUARIOS_ENDPOINT, UsuarioDTO[].class);
        if (usuarioResponse.getStatusCode().is2xxSuccessful()) {
            UsuarioDTO[] body = usuarioResponse.getBody();
            List<UsuarioDTO> usu = Arrays.asList(body);
           // usu.stream().forEach(p -> log.info("Usuarios: {}", p));// CON ESTO PUEDES VER LOS DATOS EN EL LOG SI QUIERES

            usuarios = usu;
        }
        return Optional.of(usuarios);
    }

    public Optional<UsuarioDTO> getUsuario(Integer id) {

        UsuarioDTO usuario = null;
        ResponseEntity<UsuarioDTO> usuarioResponse = restTemplate.getForEntity(USUARIOS_ENDPOINT+"/"+id, UsuarioDTO.class);
        if (usuarioResponse.getStatusCode().is2xxSuccessful()) {
            UsuarioDTO body = usuarioResponse.getBody();
            UsuarioDTO usu = body;

            usuario = usu;
        }
        return Optional.of(usuario);
    }

    public Optional<UsuarioDTO> getUsuarioByEmail(String email) {

        UsuarioDTO usuario = null;
        ResponseEntity<UsuarioDTO> usuarioResponse = restTemplate.getForEntity(USUARIOS_POR_EMAIL+"/"+email, UsuarioDTO.class);
        if (usuarioResponse.getStatusCode().is2xxSuccessful()) {
            UsuarioDTO body = usuarioResponse.getBody();
            UsuarioDTO usu = body;

            usuario = usu;
        }
        return Optional.of(usuario);
    }


    public Optional<List<UsuarioDTO>> getUsuariosPorRol() {

        List<UsuarioDTO> usuarios = null;
        ResponseEntity<UsuarioDTO[]> usuarioResponse = restTemplate.getForEntity(USUARIOS_POR_ROL_ENDPOINT+"/"+3, UsuarioDTO[].class);
        if (usuarioResponse.getStatusCode().is2xxSuccessful()) {
            UsuarioDTO[] body = usuarioResponse.getBody();
            List<UsuarioDTO> usu = Arrays.asList(body);
            // usu.stream().forEach(p -> log.info("Usuarios: {}", p));// CON ESTO PUEDES VER LOS DATOS EN EL LOG SI QUIERES

            usuarios = usu;
        }
        return Optional.of(usuarios);
    }


    public UsuarioDTO createUsuarios(UsuarioDTO usuarioDTO){
        HttpEntity<UsuarioDTO> request = new HttpEntity<>(usuarioDTO);
        UsuarioDTO productDtoResponse = restTemplate.postForObject(USUARIOS_ENDPOINT, request, UsuarioDTO.class);
        assert productDtoResponse != null;
        return productDtoResponse;
    }

    public void updateUsuarios(UsuarioDTO usuarioDTO){
        HttpEntity<UsuarioDTO> request = new HttpEntity<>(usuarioDTO);
        restTemplate.put(USUARIOS_ENDPOINT, request, UsuarioDTO.class);
    }



    public boolean activeUsuario(Integer id){

        HttpEntity<Integer> request= new HttpEntity<>(id);
        restTemplate.exchange(USUARIOS_LOGIC_ACTIVE_ENDPOINT+"/"+id, HttpMethod.PUT,request,Integer.class);
        return true;
    }

    public boolean deactivateUsuario(Integer id){

        HttpEntity<Integer> request= new HttpEntity<>(id);
        restTemplate.exchange(USUARIOS_LOGIC_DELETE_ENDPOINT+"/"+id, HttpMethod.PUT,request,Integer.class);
        return true;
    }




}
