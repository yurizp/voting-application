package br.com.igorc.voting.service;

import br.com.igorc.voting.converter.AssociateConverter;
import br.com.igorc.voting.converter.AssociateEntityConverter;
import br.com.igorc.voting.domain.Associate;
import br.com.igorc.voting.entity.AssociateEntity;
import br.com.igorc.voting.repository.AssociateRepository;
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
public class AssociateServiceTest {

    @InjectMocks
    private AssociateService associateService;

    @Mock
    private AssociateRepository repository;

    @Mock
    private AssociateEntityConverter associateEntityConverter;

    @Mock
    private AssociateConverter associateConverter;

    @Test
    public void verifyThatCreateCallsEntityConverter() {
        Associate expectedArgument = new Associate(null, "0011223344556");
        associateService.create(expectedArgument);
        verify(associateEntityConverter).convert(expectedArgument);
    }

    @Test
    public void verifyThatCreateCallsAssociateConverter() {
        Associate associate = Mockito.mock(Associate.class);
        AssociateEntity expectedArgument = new AssociateEntity(1L, "0011223344556");

        when(associateEntityConverter.convert(Mockito.any()))
                .thenReturn(expectedArgument);

        associateService.create(associate);

        verify(associateConverter).convert(expectedArgument);
    }

    @Test
    public void verifyThatCreateCallsRepository() {
        Associate associate = Mockito.mock(Associate.class);
        AssociateEntity expectedArgument = new AssociateEntity(null, "0011223344556");

        when(associateEntityConverter.convert(Mockito.any()))
                .thenReturn(expectedArgument);

        associateService.create(associate);

        verify(repository).save(expectedArgument);
    }

    @Test
    public void verifyThatListCallsAssociateConverter() {
        AssociateEntity expectedArgument = new AssociateEntity(1L, "0011223344556");

        when(repository.findAll(Mockito.any(PageRequest.class)))
                .thenReturn(new PageImpl<>(Arrays.asList(expectedArgument)));

        associateService.list(0);

        verify(associateConverter).convert(expectedArgument);
    }

}
