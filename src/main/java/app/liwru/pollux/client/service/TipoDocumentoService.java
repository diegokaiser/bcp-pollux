package app.liwru.pollux.client.service;

import app.liwru.pollux.dto.TipoDocumentoDTO;
import app.liwru.pollux.dto.TipoDocumentoDTO;
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
public class TipoDocumentoService {

   private static final String TIPOS_DOCUMENTOS_ENDPOINT = "http://localhost:9000/api/tipos-documentos";


    private final RestTemplate restTemplate;

    public TipoDocumentoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Optional<List<TipoDocumentoDTO>> getTipoDocumentos() {

        List<TipoDocumentoDTO> tipoDocumentos = null;
        ResponseEntity<TipoDocumentoDTO[]> tipoDocumentosResponse = restTemplate.getForEntity(TIPOS_DOCUMENTOS_ENDPOINT, TipoDocumentoDTO[].class);
        if (tipoDocumentosResponse.getStatusCode().is2xxSuccessful()) {
            TipoDocumentoDTO[] body = tipoDocumentosResponse.getBody();
            List<TipoDocumentoDTO> tipoDoc = Arrays.asList(body);
           // tipoDoc.stream().forEach(p -> log.info("TipoDocumentos: {}", p));// CON ESTO PUEDES VER LOS DATOS EN EL LOG SI QUIERES

            tipoDocumentos = tipoDoc;
        }
        return Optional.of(tipoDocumentos);
    }






}
