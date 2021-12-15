package app.liwru.pollux.dto;

import lombok.*;


@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MotivoDTO {
    private Integer idMotivo;
    private String estadoDescripcion;
    private Integer estadoMotivo;

}
