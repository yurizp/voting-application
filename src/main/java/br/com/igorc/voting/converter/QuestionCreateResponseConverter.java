package br.com.igorc.voting.converter;

import br.com.igorc.voting.api.v1.response.QuestionCreateResponse;
import br.com.igorc.voting.domain.Question;
import org.springframework.stereotype.Component;

@Component
public class QuestionCreateResponseConverter {
    public QuestionCreateResponse convert(Question created) {
        return new QuestionCreateResponse(created.getId(), created.getDescription());
    }
}
