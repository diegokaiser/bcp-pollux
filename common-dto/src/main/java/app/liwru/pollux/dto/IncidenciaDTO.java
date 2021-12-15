package app.liwru.pollux.dto;
import lombok.*;

import java.time.LocalDate;


@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class IncidenciaDTO {
    private Integer idIncidencia;
    private String codigoIncidencia;
    private LocalDate fechaIncidencia;
    private Integer tipoAtencion;
    private String fechaAproximada;
    private Integer existeDocs;
    private Integer fileDocs;
    private String pedidoIncidencia;
    private String detalleIncidencia;
    private Integer tipoContacto;
    private String justificacionIncidencia;
    private String actualizadoPor;

    private Integer idMotivo;
    private Integer idTipoDoc;
    private Integer idEstado;
    private Integer idSede;
    private Integer idAgraviado;
    private Integer idUsuario;
    private Integer idTipoIncidencia;

    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate deletedAt;

    private UsuarioDTO usuario;
    private TipoIncidenciaDTO tipoIncidencia;
    private MotivoDTO motivo;
    private EstadoDTO estado;
    private AgraviadoDTO agraviado;
    private SedeDTO sede;

}
