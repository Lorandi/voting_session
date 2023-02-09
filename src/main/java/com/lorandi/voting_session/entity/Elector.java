package com.lorandi.voting_session.entity;

import com.lorandi.voting_session.enums.ElectorStatusEnum;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;

@Entity
@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "elector")
public class Elector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    @Enumerated(STRING)
    private ElectorStatusEnum status;

}
