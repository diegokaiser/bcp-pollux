package app.liwru.pollux.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.List;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private Integer idUsuario;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String emailUsuario;
    private String numeroDocUsuario;
    private String contrasena;
    private Integer estado;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate deletedAt;
    private Integer idRolUsuario;
    private Integer idTipoDoc;
    private RolDTO rol;
    private TipoDocumentoDTO tipoDocumento;
    private String token;
}

