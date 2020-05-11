package br.com.igorc.voting.service;

import br.com.igorc.voting.converter.QuestionConverter;
import br.com.igorc.voting.converter.QuestionEntityConverter;
import br.com.igorc.voting.domain.Question;
import br.com.igorc.voting.entity.QuestionEntity;
import br.com.igorc.voting.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Arrays;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class QuestionServiceTest {

    @InjectMocks
    private QuestionService questionService;

    @Mock
    private QuestionRepository repository;

    @Mock
    private QuestionEntityConverter questionEntityConverter;

    @Mock
    private QuestionConverter questionConverter;

    @Test
    public void verifyThatCreateCallsEntityConverter() {
        Question expectedArgument = new Question(null, "Exemplo");
        questionService.create(expectedArgument);
        verify(questionEntityConverter).convert(expectedArgument);
    }

    @Test
    public void verifyThatCreateCallsQuestionConverter() {
        Question question = Mockito.mock(Question.class);
        QuestionEntity expectedArgument = new QuestionEntity(1L, "Exemplo");

        when(questionEntityConverter.convert(Mockito.any()))
                .thenReturn(expectedArgument);

        questionService.create(question);

        verify(questionConverter).convert(expectedArgument);
    }

    @Test
    public void verifyThatCreateCallsRepository() {
        Question question = Mockito.mock(Question.class);
        QuestionEntity expectedArgument = new QuestionEntity(null, "Exemplo");

        when(questionEntityConverter.convert(Mockito.any()))
                .thenReturn(expectedArgument);

        questionService.create(question);

        verify(repository).save(expectedArgument);
    }

    @Test
    public void verifyThatListCallsQuestionConverter() {
        QuestionEntity expectedArgument = new QuestionEntity(1L, "Exemplo");

        when(repository.findAll(Mockito.any(PageRequest.class)))
                .thenReturn(new PageImpl<>(Arrays.asList(expectedArgument)));

        questionService.list(0);

        verify(questionConverter).convert(expectedArgument);
    }

}
