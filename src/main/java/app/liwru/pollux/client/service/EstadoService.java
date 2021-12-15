package app.liwru.pollux.client.service;

import app.liwru.pollux.dto.EstadoDTO;
import app.liwru.pollux.dto.EstadoDTO;
import app.liwru.pollux.dto.EstadoDTO;
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
public class EstadoService {

    //private static final String PRODUCT_ENDPOINT = "https://liwru-pollux-apis.herokuapp.com/api/estados";
   private static final String ESTADOS_ENDPOINT = "http://localhost:9000/api/estados";


    private final RestTemplate restTemplate;

    public EstadoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Optional<List<EstadoDTO>> getEstados() {

        List<EstadoDTO> estados = null;
        ResponseEntity<EstadoDTO[]> usuarioResponse = restTemplate.getForEntity(ESTADOS_ENDPOINT, EstadoDTO[].class);
        if (usuarioResponse.getStatusCode().is2xxSuccessful()) {
            EstadoDTO[] body = usuarioResponse.getBody();
            List<EstadoDTO> usu = Arrays.asList(body);
            //usu.stream().forEach(p -> log.info("Usuarios: {}", p));// CON ESTO PUEDES VER LOS DATOS EN EL LOG SI QUIERES

            estados = usu;
        }
        return Optional.of(estados);
    }

    public EstadoDTO createEstado(EstadoDTO estadoDTO){
        HttpEntity<EstadoDTO> request = new HttpEntity<>(estadoDTO);
        EstadoDTO estadoDtoResponse = restTemplate.postForObject(ESTADOS_ENDPOINT, request, EstadoDTO.class);
        assert estadoDtoResponse != null;
        return estadoDtoResponse;
    }

    public void updateEstados(EstadoDTO estadoDTO){
        HttpEntity<EstadoDTO> request = new HttpEntity<>(estadoDTO);
        restTemplate.put(ESTADOS_ENDPOINT, request, EstadoDTO.class);
    }





}
