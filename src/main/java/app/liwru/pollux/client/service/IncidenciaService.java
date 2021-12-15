package app.liwru.pollux.client.service;

import app.liwru.pollux.dto.DepartamentoDTO;
import app.liwru.pollux.dto.IncidenciaDTO;
import app.liwru.pollux.dto.UsuarioDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Configuration
@Slf4j
@Service
public class IncidenciaService {

  //  private static final String PRODUCT_ENDPOINT = "https://liwru-pollux-apis.herokuapp.com/api/incidencias";
    private static final String INCIDENCIA_ENDPOINT = "http://localhost:9000/api/incidencias";
    private static final String INCIDENCIA_AGRAVIADO_ENDPOINT = "http://localhost:9000/api/incidencias/getPorAgraviado";
    private static final String INCIDENCIA_ESTADO_RESERVA_ENDPOINT = "http://localhost:9000/api/incidencias/estadoPorResponsable";


    private final RestTemplate restTemplate;




    public IncidenciaService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Optional<List<IncidenciaDTO>> getIncidencias() {

        List<IncidenciaDTO> incidencias = null;
        ResponseEntity<IncidenciaDTO[]> incidenciaResponse = restTemplate.getForEntity(INCIDENCIA_ENDPOINT, IncidenciaDTO[].class);
        if (incidenciaResponse.getStatusCode()== HttpStatus.OK) {
            IncidenciaDTO[] body = incidenciaResponse.getBody();
            List<IncidenciaDTO> inci = Arrays.asList(body);
            //inci.stream().forEach(p -> log.info("Incidencias: {}", p)); //CON ESTO PUEDES VER LOS DATOS EN EL LOG SI QUIERES

            incidencias = inci;
        }
        return Optional.of(incidencias);
    }

    public Optional<List<IncidenciaDTO>> getIncidenciasPorAgraviado(Integer id) {

        List<IncidenciaDTO> incidencias = null;
        ResponseEntity<IncidenciaDTO[]> incidenciaResponse = restTemplate.getForEntity(INCIDENCIA_AGRAVIADO_ENDPOINT+"/"+id, IncidenciaDTO[].class);
        if (incidenciaResponse.getStatusCode()== HttpStatus.OK) {
            IncidenciaDTO[] body = incidenciaResponse.getBody();
            List<IncidenciaDTO> inci = Arrays.asList(body);
            //inci.stream().forEach(p -> log.info("Incidencias: {}", p)); //CON ESTO PUEDES VER LOS DATOS EN EL LOG SI QUIERES

            incidencias = inci;
        }
        return Optional.of(incidencias);
    }

    public Optional<IncidenciaDTO> getIncidencia(Integer id) {

        IncidenciaDTO incidencia = null;
        ResponseEntity<IncidenciaDTO> incidenciaResponse = restTemplate.getForEntity(INCIDENCIA_ENDPOINT+"/"+id, IncidenciaDTO.class);
        if (incidenciaResponse.getStatusCode().is2xxSuccessful()) {
            IncidenciaDTO body = incidenciaResponse.getBody();
            IncidenciaDTO inci = (body);
            incidencia = inci;
        }
        return Optional.of(incidencia);
    }

    public void updateIncidencia(IncidenciaDTO incidenciaDTO){//Actualiza estado y al usuario
        HttpEntity<IncidenciaDTO> request = new HttpEntity<>(incidenciaDTO);
        restTemplate.put(INCIDENCIA_ENDPOINT, request, IncidenciaDTO.class);
    }
/*
    public IncidenciaDTO setEstadoResponsable(IncidenciaDTO incidenciaDTO){
        HttpEntity<IncidenciaDTO> request = new HttpEntity<>(incidenciaDTO);
        ResponseEntity<IncidenciaDTO> incidenciaResponse =  restTemplate.exchange(INCIDENCIA_ESTADO_RESERVA_ENDPOINT+"/"+incidenciaDTO.getIdIncidencia(),HttpMethod.PUT, request, IncidenciaDTO.class);
        return incidenciaResponse;
    }
*/

/*    public boolean deactivateUsuario(Integer id){

        HttpEntity<Integer> request= new HttpEntity<>(id);
        restTemplate.exchange(USUARIOS_LOGIC_DELETE_ENDPOINT+"/"+id, HttpMethod.PUT,request,Integer.class);
        return true;
    }*/


}
