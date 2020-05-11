package br.com.igorc.voting.converter;

import br.com.igorc.voting.api.v1.response.QuestionCreateResponse;
import br.com.igorc.voting.domain.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuestionCreateResponseConverterTest {

    private final Long id = 1L;
    private final String description = "Exemplo";

    @Test
    public void convertQuestionToResponse() {
        Question associate = new Question(id, description);

        QuestionCreateResponseConverter converter = new QuestionCreateResponseConverter();

        QuestionCreateResponse actual = converter.convert(associate);
        QuestionCreateResponse expected = new QuestionCreateResponse(id, description);

        Assertions.assertEquals(expected, actual);
    }

}
