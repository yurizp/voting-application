package br.com.igorc.voting.converter;

import br.com.igorc.voting.api.v1.response.QuestionListResponse;
import br.com.igorc.voting.api.v1.response.QuestionResponse;
import br.com.igorc.voting.domain.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Arrays;
import java.util.List;

public class QuestionListResponseConverterTest {

    @Test
    public void createResponse() {
        QuestionListResponseConverter converter = new QuestionListResponseConverter();

        List<Question> questionList = Arrays.asList(
                new Question(1L, "Exemplo 1"),
                new Question(2L, "Exemplo 2")
        );
        Page<Question> page = new PageImpl(questionList);

        QuestionListResponse actual = converter.convert(page);

        List<QuestionResponse> expectedQuestionResponseList = Arrays.asList(
                new QuestionResponse(1L, "Exemplo 1"),
                new QuestionResponse(2L, "Exemplo 2")
        );
        QuestionListResponse expected = new QuestionListResponse(expectedQuestionResponseList, 0, 0);

        Assertions.assertEquals(expected, actual);
    }

}