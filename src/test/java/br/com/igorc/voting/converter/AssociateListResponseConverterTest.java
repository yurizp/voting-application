package br.com.igorc.voting.converter;

import br.com.igorc.voting.api.v1.response.AssociateListResponse;
import br.com.igorc.voting.api.v1.response.AssociateResponse;
import br.com.igorc.voting.domain.Associate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Arrays;
import java.util.List;

public class AssociateListResponseConverterTest {

    @Test
    public void createResponse() {
        AssociateListResponseConverter converter = new AssociateListResponseConverter();

        List<Associate> associateList = Arrays.asList(
                new Associate(1L, "11223344556"),
                new Associate(2L, "77223344556")
        );
        Page<Associate> page = new PageImpl(associateList);

        AssociateListResponse actual = converter.convert(page);

        List<AssociateResponse> expectedAssociateResponseList = Arrays.asList(
                new AssociateResponse(1L, "11223344556"),
                new AssociateResponse(2L, "77223344556")
        );
        AssociateListResponse expected = new AssociateListResponse(expectedAssociateResponseList, 0, 0);

        Assertions.assertEquals(expected, actual);
    }

}