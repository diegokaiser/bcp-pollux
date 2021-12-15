package app.liwru.pollux.client.service;

import app.liwru.pollux.dto.DocumentoDTO;
import app.liwru.pollux.dto.DocumentoDTO;
import app.liwru.pollux.dto.MotivoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Configuration
@Slf4j
@Service
public class DocumentoService {

   private static final String DOCUMENTOS_ENDPOINT = "http://localhost:9000/api/documentos/getByIdIncidencia";



    private final RestTemplate restTemplate;

    public DocumentoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Optional<List<DocumentoDTO>> getDocumentosByIdIncidencia(Integer id) {

        List<DocumentoDTO> documentos = null;
        ResponseEntity<DocumentoDTO[]> documentoResponse = restTemplate.getForEntity(DOCUMENTOS_ENDPOINT +"/"+id, DocumentoDTO[].class);
        if (documentoResponse.getStatusCode().is2xxSuccessful()) {
            DocumentoDTO[] body = documentoResponse.getBody();
            List<DocumentoDTO> documento = Arrays.asList(body);
        //    documento.stream().forEach(p -> log.info("Documentos: {}", p));// CON ESTO PUEDES VER LOS DATOS EN EL LOG SI QUIERES

            documentos = documento;
        }
        return Optional.of(documentos);
    }






}
