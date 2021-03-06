package br.com.igorc.voting.domain;

import br.com.igorc.voting.enumeration.VoteEnumeration;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Voto
 */
@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Vote {
    private Long id;
    private VoteEnumeration vote;
    private Associate associate;
}
