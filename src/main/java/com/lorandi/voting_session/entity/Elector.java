package com.lorandi.voting_session.entity;

import lombok.*;

import javax.persistence.*;

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
    private String CPF;

}
