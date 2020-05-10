package br.com.igorc.voting.converter;

import br.com.igorc.voting.api.v1.response.AssociateListResponse;
import br.com.igorc.voting.api.v1.response.AssociateResponse;
import br.com.igorc.voting.domain.Associate;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AssociateListResponseConverter {
    public AssociateListResponse convert(Page<Associate> page) {
        List<AssociateResponse> associates = page.getContent()
                .stream()
                .map(e -> convertAssociate(e))
                .collect(Collectors.toList());
        int lastPage = page.getTotalPages() > 0 ? page.getTotalPages() - 1 : 0;
        return new AssociateListResponse(associates, page.getNumber(), lastPage);
    }

    private AssociateResponse convertAssociate(Associate associate) {
        return new AssociateResponse(associate.getId(), associate.getCpf());
    }
}
