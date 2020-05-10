package br.com.igorc.voting.converter;

import br.com.igorc.voting.api.v1.request.AssociateCreateRequest;
import br.com.igorc.voting.domain.Associate;
import br.com.igorc.voting.entity.AssociateEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssociateConverterTest {

    private final Long id = 1L;
    private final String cpf = "11223344556";

    @Test
    public void convertRequestToAssociate() {
        AssociateCreateRequest request = new AssociateCreateRequest();
        request.setCpf(cpf);

        AssociateConverter converter = new AssociateConverter();

        Associate actual = converter.convert(request);
        Associate expected = new Associate(null, cpf);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void convertEntityToAssociate() {
        AssociateEntity entity = new AssociateEntity();
        entity.setId(id);
        entity.setCpf(cpf);

        AssociateConverter converter = new AssociateConverter();

        Associate actual = converter.convert(entity);
        Associate expected = new Associate(id, cpf);

        Assertions.assertEquals(expected, actual);
    }

}
