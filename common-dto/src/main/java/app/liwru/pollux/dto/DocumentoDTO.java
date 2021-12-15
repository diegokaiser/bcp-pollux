package app.liwru.pollux.dto;

import lombok.*;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentoDTO {
    private Integer idDocumento;
    private String urlDocumento;
    private Integer idIncidencia;
}