package br.com.igorc.voting.converter;

import br.com.igorc.voting.api.v1.response.AssociateCreateResponse;
import br.com.igorc.voting.domain.Associate;
import org.springframework.stereotype.Component;

@Component
public class AssociateCreateResponseConverter {
    public AssociateCreateResponse convert(Associate associate) {
        return new AssociateCreateResponse(associate.getId(), associate.getCpf());
    }
}
