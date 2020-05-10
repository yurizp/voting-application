package br.com.igorc.voting.domain;

import br.com.igorc.voting.enumeration.VoteEnumeration;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * Sessão de votação
 */
@AllArgsConstructor
@Getter
public class VotingSession {

    private Long id;
    /**
     * Pauta em votação.
     */
    private Question question;
    /**
     * Duração da sessão em minutos.
     */
    private Integer duration;
    /**
     * Lista de votos.
     */
    private List<Vote> votes;

    /**
     * Verifica se o associado informado já votou.
     * @return verdadeiro caso o associado informado já tenha votado.
     */
    public Boolean hasAssociateVoted(Associate associate) {
        long associatePreviousVotes = votes.stream()
                .filter(v -> associate.getCpf().equals(v.getAssociate().getCpf()))
                .count();

        return associatePreviousVotes > 0;
    }

    /**
     * @return quantidade de votos "Sim".
     */
    public Long getVotesYes() {
        return votes.stream()
                .filter(v -> VoteEnumeration.YES.equals(v.getVote()))
                .count();
    }

    /**
     * @return quantidade de votos "Não".
     */
    public Long getVotesNo() {
        return votes.stream()
                .filter(v -> VoteEnumeration.NO.equals(v.getVote()))
                .count();
    }

}
