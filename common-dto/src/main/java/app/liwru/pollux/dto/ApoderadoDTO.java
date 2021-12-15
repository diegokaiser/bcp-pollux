package app.liwru.pollux.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDate;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApoderadoDTO {

    private Integer idApoderado;
    private String apoderadoNombre;
    private String apoderadoApellidoPat;
    private String apoderadoApellidoMat;
    private String apoderadoTelefono;
    private String apoderadoEmail;
    private String apoderadoNroDoc;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private TipoDocumentoDTO tipoDocumento;
}
