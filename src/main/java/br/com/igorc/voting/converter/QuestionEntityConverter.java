package br.com.igorc.voting.converter;

import br.com.igorc.voting.domain.Question;
import br.com.igorc.voting.entity.QuestionEntity;
import org.springframework.stereotype.Component;

@Component
public class QuestionEntityConverter {
    public QuestionEntity convert(Question domain) {
        return new QuestionEntity(domain.getId(), domain.getDescription());
    }
}
