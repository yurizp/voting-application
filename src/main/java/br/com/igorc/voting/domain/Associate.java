package br.com.igorc.voting.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Associado
 */
@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Associate {
    private Long id;
    private String cpf;
}
