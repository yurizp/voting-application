package br.com.igorc.voting.converter;

import br.com.igorc.voting.domain.Associate;
import br.com.igorc.voting.entity.AssociateEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssociateEntityConverterTest {

    private final Long id = 1L;
    private final String cpf = "11223344556";

    @Test
    public void convertAssociateToEntity() {
        Associate associate = new Associate(id, cpf);

        AssociateEntityConverter converter = new AssociateEntityConverter();

        AssociateEntity actual = converter.convert(associate);
        AssociateEntity expected = new AssociateEntity(id, cpf);

        Assertions.assertEquals(expected, actual);
    }

}
