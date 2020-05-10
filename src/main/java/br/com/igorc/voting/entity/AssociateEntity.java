package br.com.igorc.voting.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "associate")
@Data
@NoArgsConstructor
public class AssociateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "associate_seq")
    @SequenceGenerator(name = "associate_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String cpf;
}
