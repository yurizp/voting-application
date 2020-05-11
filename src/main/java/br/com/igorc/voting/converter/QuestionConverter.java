package br.com.igorc.voting.converter;

import br.com.igorc.voting.api.v1.request.QuestionCreateRequest;
import br.com.igorc.voting.domain.Question;
import br.com.igorc.voting.entity.QuestionEntity;
import org.springframework.stereotype.Component;

@Component
public class QuestionConverter {
    public Question convert(QuestionEntity entity) {
        return new Question(entity.getId(), entity.getDescription());
    }

    public Question convert(QuestionCreateRequest request) {
        return new Question(null, request.getDescription());
    }
}
