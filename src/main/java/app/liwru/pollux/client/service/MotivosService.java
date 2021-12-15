package app.liwru.pollux.client.service;

import app.liwru.pollux.dto.MotivoDTO;
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
public class MotivosService {

   private static final String MOTIVOS_ENDPOINT = "http://localhost:9000/api/motivos";
    private static final String MOTIVOS_ACTIVE_ENDPOINT = "http://localhost:9000/api/motivos/activeMotivo";
    private static final String MOTIVOS_DEACTIVATE_ENDPOINT = "http://localhost:9000/api/motivos/deleteMotivo";



    private final RestTemplate restTemplate;

    public MotivosService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Optional<List<MotivoDTO>> getMotivos() {

        List<MotivoDTO> motivos = null;
        ResponseEntity<MotivoDTO[]> motivoResponse = restTemplate.getForEntity(MOTIVOS_ENDPOINT, MotivoDTO[].class);
        if (motivoResponse.getStatusCode().is2xxSuccessful()) {
            MotivoDTO[] body = motivoResponse.getBody();
            List<MotivoDTO> motivo = Arrays.asList(body);
          //  motivo.stream().forEach(p -> log.info("Motivos: {}", p));// CON ESTO PUEDES VER LOS DATOS EN EL LOG SI QUIERES

            motivos = motivo;
        }
        return Optional.of(motivos);
    }

    public Optional<MotivoDTO> getMotivo(Integer id) {

        MotivoDTO motivos = null;
        ResponseEntity<MotivoDTO> motivoResponse = restTemplate.getForEntity(MOTIVOS_ENDPOINT+"/"+id, MotivoDTO.class);
        if (motivoResponse.getStatusCode().is2xxSuccessful()) {
            MotivoDTO body = motivoResponse.getBody();
            MotivoDTO motivo = body;
            motivos = motivo;
        }
        return Optional.of(motivos);
    }

    public MotivoDTO createMotivos(MotivoDTO motivoDTO){
        HttpEntity<MotivoDTO> request = new HttpEntity<>(motivoDTO);
        MotivoDTO motivoDtoResponse = restTemplate.postForObject(MOTIVOS_ENDPOINT, request, MotivoDTO.class);
        assert motivoDtoResponse != null;
        return motivoDtoResponse;
    }


    public void updateMotivos(MotivoDTO motivoDTO){
        HttpEntity<MotivoDTO> request = new HttpEntity<>(motivoDTO);
        restTemplate.put(MOTIVOS_ENDPOINT, request, SedeDTO.class);
    }


    public boolean activeMotivos(Integer id){

        HttpEntity<Integer> request= new HttpEntity<>(id);
        restTemplate.exchange(MOTIVOS_ACTIVE_ENDPOINT+"/"+id, HttpMethod.PUT,request,Integer.class);
        return true;
    }

    public boolean deactivateMotivos(Integer id){

        HttpEntity<Integer> request= new HttpEntity<>(id);
        restTemplate.exchange(MOTIVOS_DEACTIVATE_ENDPOINT+"/"+id, HttpMethod.PUT,request,Integer.class);
        return true;
    }







}
