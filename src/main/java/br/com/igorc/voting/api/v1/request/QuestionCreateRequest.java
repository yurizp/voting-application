package br.com.igorc.voting.api.v1.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@ApiModel
public class QuestionCreateRequest {
    @ApiModelProperty(name = "Descrição", value = "Descrição da pauta.")
    @NotEmpty(message = "O campo Descrição é obrigatório.")
    private String description;
}
