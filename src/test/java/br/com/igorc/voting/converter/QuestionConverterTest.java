package br.com.igorc.voting.converter;

import br.com.igorc.voting.api.v1.request.QuestionCreateRequest;
import br.com.igorc.voting.domain.Question;
import br.com.igorc.voting.entity.QuestionEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuestionConverterTest {

    private final Long id = 1L;
    private final String description = "Exemplo";

    @Test
    public void convertRequestToQuestion() {
        QuestionCreateRequest request = new QuestionCreateRequest();
        request.setDescription(description);

        QuestionConverter converter = new QuestionConverter();

        Question actual = converter.convert(request);
        Question expected = new Question(null, description);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void convertEntityToQuestion() {
        QuestionEntity entity = new QuestionEntity();
        entity.setId(id);
        entity.setDescription(description);

        QuestionConverter converter = new QuestionConverter();

        Question actual = converter.convert(entity);
        Question expected = new Question(id, description);

        Assertions.assertEquals(expected, actual);
    }

}
