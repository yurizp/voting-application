package br.com.igorc.voting.api.v1.request;

import br.com.caelum.stella.bean.validation.CPF;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@ApiModel
public class AssociateCreateRequest {
    @ApiModelProperty(name = "CPF", value = "CPF do associado.")
    @NotEmpty(message = "O campo CPF é obrigatório.")
    @CPF(message = "O campo CPF deve conter um número válido.")
    private String cpf;
}
