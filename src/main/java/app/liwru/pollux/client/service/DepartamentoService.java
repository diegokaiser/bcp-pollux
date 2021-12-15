package app.liwru.pollux.client.service;

import app.liwru.pollux.dto.DepartamentoDTO;
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
public class DepartamentoService {

    private static final String PRODUCT_ENDPOINT = "http://localhost:9000/api/departamentos";
    private final RestTemplate restTemplate;

    public DepartamentoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Optional<List<DepartamentoDTO>> getDepartamentos() {

        List<DepartamentoDTO> departamentos = null;
        ResponseEntity<DepartamentoDTO[]> departamentoResponse = restTemplate.getForEntity(PRODUCT_ENDPOINT, DepartamentoDTO[].class);
        if (departamentoResponse.getStatusCode().is2xxSuccessful()) {
            DepartamentoDTO[] body = departamentoResponse.getBody();
            List<DepartamentoDTO> depas = Arrays.asList(body);
           // depas.stream().forEach(p -> log.info("Departamento: {}", p)); // CON ESTO PUEDES VER LOS DATOS EN EL LOG SI QUIERES

            departamentos = depas;
        }
        return Optional.of(departamentos);
    }
}



