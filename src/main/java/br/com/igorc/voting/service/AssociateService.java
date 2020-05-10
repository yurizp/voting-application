package br.com.igorc.voting.service;

import br.com.igorc.voting.converter.AssociateConverter;
import br.com.igorc.voting.converter.AssociateEntityConverter;
import br.com.igorc.voting.domain.Associate;
import br.com.igorc.voting.entity.AssociateEntity;
import br.com.igorc.voting.repository.AssociateRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AssociateService {

    private AssociateRepository repository;

    private AssociateEntityConverter associateEntityConverter;

    private AssociateConverter associateConverter;

    private final Integer PAGE_SIZE = 10;

    public Associate create(Associate associate) {
        AssociateEntity entity = associateEntityConverter.convert(associate);
        repository.save(entity);
        return associateConverter.convert(entity);
    }

    public Page<Associate> list(int page) {
        PageRequest pageRequest = PageRequest.of(page, PAGE_SIZE);
        return repository.findAll(pageRequest).map(e -> associateConverter.convert(e));
    }

}
