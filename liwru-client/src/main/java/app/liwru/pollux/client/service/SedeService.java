package app.liwru.pollux.client.service;

import app.liwru.pollux.dto.SedeDTO;
import app.liwru.pollux.dto.SedeDTO;
import app.liwru.pollux.dto.SedeDTO;
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
public class SedeService {

   private static final String SEDES_ENDPOINT = "http://localhost:9000/api/sedes";
    private static final String SEDES_ACTIVE_ENDPOINT = "http://localhost:9000/api/sedes/activeSede";
    private static final String SEDES_DEACTIVATE_ENDPOINT = "http://localhost:9000/api/sedes/deleteSede";



    private final RestTemplate restTemplate;

    public SedeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Optional<List<SedeDTO>> getSedes() {

        List<SedeDTO> sedes = null;
        ResponseEntity<SedeDTO[]> sedeResponse = restTemplate.getForEntity(SEDES_ENDPOINT, SedeDTO[].class);
        if (sedeResponse.getStatusCode().is2xxSuccessful()) {
            SedeDTO[] body = sedeResponse.getBody();
            List<SedeDTO> sede = Arrays.asList(body);
            //sede.stream().forEach(p -> log.info("Sedes: {}", p));// CON ESTO PUEDES VER LOS DATOS EN EL LOG SI QUIERES

            sedes = sede;
        }
        return Optional.of(sedes);
    }

    public Optional<SedeDTO> getSede(Integer id) {

        SedeDTO sedeDTO = null;
        ResponseEntity<SedeDTO> sedeResponse = restTemplate.getForEntity(SEDES_ENDPOINT+"/"+id, SedeDTO.class);
        if (sedeResponse.getStatusCode().is2xxSuccessful()) {
            SedeDTO body = sedeResponse.getBody();
            SedeDTO sede = body;

            sedeDTO = sede;
        }
        return Optional.of(sedeDTO);
    }


    public SedeDTO createSedes(SedeDTO sedeDTO){
        HttpEntity<SedeDTO> request = new HttpEntity<>(sedeDTO);
        SedeDTO sedeDtoResponse = restTemplate.postForObject(SEDES_ENDPOINT, request, SedeDTO.class);
        assert sedeDtoResponse != null;
        return sedeDtoResponse;
    }


    public void updateSede(SedeDTO sedeDTO){
        HttpEntity<SedeDTO> request = new HttpEntity<>(sedeDTO);
        restTemplate.put(SEDES_ENDPOINT, request, SedeDTO.class);
    }

    public boolean activeSede(Integer id){

        HttpEntity<Integer> request= new HttpEntity<>(id);
        restTemplate.exchange(SEDES_ACTIVE_ENDPOINT+"/"+id, HttpMethod.PUT,request,Integer.class);
        return true;
    }

    public boolean deactivateSede(Integer id){

        HttpEntity<Integer> request= new HttpEntity<>(id);
        restTemplate.exchange(SEDES_DEACTIVATE_ENDPOINT+"/"+id, HttpMethod.PUT,request,Integer.class);
        return true;
    }







}
