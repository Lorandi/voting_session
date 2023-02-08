package com.lorandi.voting_session.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vote")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long surveyId;
    private Long electorId;
    private Boolean approval;
}
