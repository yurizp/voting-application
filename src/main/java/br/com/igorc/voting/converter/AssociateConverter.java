package br.com.igorc.voting.converter;

import br.com.igorc.voting.api.v1.request.AssociateCreateRequest;
import br.com.igorc.voting.domain.Associate;
import br.com.igorc.voting.entity.AssociateEntity;
import org.springframework.stereotype.Component;

@Component
public class AssociateConverter {
    public Associate convert(AssociateEntity entity) {
        return new Associate(entity.getId(), entity.getCpf());
    }
    public Associate convert(AssociateCreateRequest request) {
        return new Associate(null, request.getCpf());
    }
}
