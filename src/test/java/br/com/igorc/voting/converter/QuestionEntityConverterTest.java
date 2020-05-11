package br.com.igorc.voting.converter;

import br.com.igorc.voting.domain.Question;
import br.com.igorc.voting.entity.QuestionEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuestionEntityConverterTest {

    private final Long id = 1L;
    private final String description = "Exemplo";

    @Test
    public void convertQuestionToEntity() {
        Question question = new Question(id, description);

        QuestionEntityConverter converter = new QuestionEntityConverter();

        QuestionEntity actual = converter.convert(question);
        QuestionEntity expected = new QuestionEntity(id, description);

        Assertions.assertEquals(expected, actual);
    }

}
