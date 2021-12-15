package app.liwru.pollux.dto;

import lombok.*;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DistritoDTO {

    private Integer idDistrito;
    private String nombre;
    private Integer idProvincia;
    private ProvinciaDTO provincia;

}
