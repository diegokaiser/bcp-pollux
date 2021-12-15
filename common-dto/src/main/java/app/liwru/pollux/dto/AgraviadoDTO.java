package app.liwru.pollux.dto;

import lombok.*;
import java.time.LocalDate;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AgraviadoDTO {

    private Integer idAgraviado;
    private String clienteNombre;
    private String clienteApeMat;
    private String clienteApePat;
    private String clienteEmail;
    private String clienteTelefono;
    private String clienteDireccion;
    private String clienteNroDoc;
    private Integer estatusEdad;
    private Integer estado;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private DistritoDTO distrito;
    private TipoDocumentoDTO tipoDocumento;

    private Integer idTipoDoc;
    private Integer idApoderado;
    private Integer idDepartamento;
    private Integer idProvincia;
    private Integer idDistrito;


}
