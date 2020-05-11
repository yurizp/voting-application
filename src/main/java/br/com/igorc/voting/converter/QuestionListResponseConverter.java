package br.com.igorc.voting.converter;

import br.com.igorc.voting.api.v1.response.QuestionListResponse;
import br.com.igorc.voting.api.v1.response.QuestionResponse;
import br.com.igorc.voting.domain.Question;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionListResponseConverter extends ListResponseConverter<QuestionListResponse, Question, QuestionResponse> {

    @Override
    protected QuestionListResponse createResponse(List<QuestionResponse> content, int currentPage, int lastPage) {
        return new QuestionListResponse(content, currentPage, lastPage);
    }

    @Override
    protected QuestionResponse convertElement(Question question) {
        return new QuestionResponse(question.getId(), question.getDescription());
    }
}
