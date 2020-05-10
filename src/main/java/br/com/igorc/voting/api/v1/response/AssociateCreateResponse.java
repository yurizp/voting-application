package br.com.igorc.voting.api.v1.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AssociateCreateResponse {
    @ApiModelProperty(name = "ID", value = "Código do associado.")
    private Long id;
    @ApiModelProperty(name = "CPF", value = "CPF do associado.")
    private String cpf;
}
