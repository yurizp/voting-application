package br.com.igorc.voting.repository;

import br.com.igorc.voting.entity.QuestionEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends PagingAndSortingRepository<QuestionEntity, Long> {
}
