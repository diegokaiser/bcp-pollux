package app.liwru.pollux.dto;

import lombok.*;

import java.time.LocalDate;
@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaDTO {


    private Integer idEmpresa;
    private String rucEmpresa;
    private String telefonoEmpresa;
    private String descripcionEmpresa;
    private LocalDate createAt;
    private String updateAt;


}
