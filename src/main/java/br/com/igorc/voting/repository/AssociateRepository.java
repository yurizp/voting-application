package br.com.igorc.voting.repository;

import br.com.igorc.voting.entity.AssociateEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociateRepository extends PagingAndSortingRepository<AssociateEntity, Long> {
}
