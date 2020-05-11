package br.com.igorc.voting.api.v1.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuestionCreateResponse {
    private Long id;
    private String description;
}
