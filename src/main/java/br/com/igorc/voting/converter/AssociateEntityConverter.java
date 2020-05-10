package br.com.igorc.voting.converter;

import br.com.igorc.voting.domain.Associate;
import br.com.igorc.voting.entity.AssociateEntity;
import org.springframework.stereotype.Component;

@Component
public class AssociateEntityConverter {
    public AssociateEntity convert(Associate associate) {
        return new AssociateEntity(associate.getId(), associate.getCpf());
    }
}
