package br.com.igorc.voting.converter;

import br.com.igorc.voting.api.v1.response.AssociateListResponse;
import br.com.igorc.voting.api.v1.response.AssociateResponse;
import br.com.igorc.voting.domain.Associate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AssociateListResponseConverter extends ListResponseConverter<AssociateListResponse, Associate, AssociateResponse> {
    @Override
    protected AssociateListResponse createResponse(List<AssociateResponse> content, int currentPage, int lastPage) {
        return new AssociateListResponse(content, currentPage, lastPage);
    }

    @Override
    protected AssociateResponse convertElement(Associate associate) {
        return new AssociateResponse(associate.getId(), associate.getCpf());
    }
}