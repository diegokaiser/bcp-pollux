package app.liwru.pollux.client.service;

import app.liwru.pollux.dto.AgraviadoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Configuration
@Slf4j
@Service
public class AgraviadosService {
/*
    private static final String PRODUCT_ENDPOINT = "https://liwru-pollux-apis.herokuapp.com/api/agraviados";
*/
    private static final String AGRAVIADOS_ENDPOINT = "http://localhost:9000/api/agraviados";
    private final RestTemplate restTemplate;

    public AgraviadosService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Optional<List<AgraviadoDTO>> getAgraviados() {

        List<AgraviadoDTO> agraviados = null;
        ResponseEntity<AgraviadoDTO[]> agraviadoResponse = restTemplate.getForEntity(AGRAVIADOS_ENDPOINT, AgraviadoDTO[].class);
        if (agraviadoResponse.getStatusCode().is2xxSuccessful()) {
            AgraviadoDTO[] body = agraviadoResponse.getBody();
            List<AgraviadoDTO> agra = Arrays.asList(body);
            //agra.stream().forEach(p -> log.info("Agraviados: {}", p));// CON ESTO PUEDES VER LOS DATOS EN EL LOG SI QUIERES

            agraviados = agra;
        }
        return Optional.of(agraviados);
    }

    public Optional<AgraviadoDTO> getAgraviado(Integer id) {

        AgraviadoDTO agraviados = null;
        ResponseEntity<AgraviadoDTO> agraviadoResponse = restTemplate.getForEntity(AGRAVIADOS_ENDPOINT+"/"+id, AgraviadoDTO.class);
        if (agraviadoResponse.getStatusCode().is2xxSuccessful()) {
            AgraviadoDTO body = agraviadoResponse.getBody();
            AgraviadoDTO agra = body;
            //agra.stream().forEach(p -> log.info("Agraviados: {}", p));// CON ESTO PUEDES VER LOS DATOS EN EL LOG SI QUIERES

            agraviados = agra;
        }
        return Optional.of(agraviados);
    }



}
