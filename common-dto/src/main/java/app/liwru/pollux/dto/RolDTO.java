package app.liwru.pollux.dto;

import lombok.*;

import javax.persistence.Entity;


@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RolDTO {


    private Integer idRolUsuario;
    private String descripcion;

}
