package br.com.igorc.voting.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Pauta
 */
@AllArgsConstructor
@Getter
public class Question {
    private Long id;
    private String description;
}
