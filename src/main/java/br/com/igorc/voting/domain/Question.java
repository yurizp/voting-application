package br.com.igorc.voting.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Pauta
 */
@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Question {
    private Long id;
    private String description;
}
