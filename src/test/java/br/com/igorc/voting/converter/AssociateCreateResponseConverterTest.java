package br.com.igorc.voting.converter;

import br.com.igorc.voting.api.v1.response.AssociateCreateResponse;
import br.com.igorc.voting.domain.Associate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssociateCreateResponseConverterTest {

    private final Long id = 1L;
    private final String cpf = "11223344556";

    @Test
    public void convertAssociateToResponse() {
        Associate associate = new Associate(id, cpf);

        AssociateCreateResponseConverter converter = new AssociateCreateResponseConverter();

        AssociateCreateResponse actual = converter.convert(associate);
        AssociateCreateResponse expected = new AssociateCreateResponse(id, cpf);

        Assertions.assertEquals(expected, actual);
    }

}
