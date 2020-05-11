package br.com.igorc.voting.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;

public abstract class AbstractService<D, E, ID> {

    private final Integer PAGE_SIZE = 10;

    public D create(D domain) {
        E entity = convertToEntity(domain);
        getRepository().save(entity);
        return convertToDomain(entity);
    }

    public Page<D> list(int page) {
        PageRequest pageRequest = PageRequest.of(page, PAGE_SIZE);
        return getRepository().findAll(pageRequest).map(e -> convertToDomain(e));
    }

    abstract protected E convertToEntity(D domain);

    protected abstract D convertToDomain(E entity);

    abstract protected PagingAndSortingRepository<E, ID> getRepository();
}
