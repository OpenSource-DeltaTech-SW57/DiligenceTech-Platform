package com.deltatech.diligencetech.platform.qa.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import org.aspectj.weaver.loadtime.Agent;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;


@Entity
@EntityListeners(AuditingEntityListener.class)
public class Question extends AbstractAggregateRoot<Question> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(nullable = false)
    @Getter
    private String buySideStatus;

    @Column(nullable = false)
    @Getter
    private String sellSideStatus;

    @Column(nullable = false)
    @Getter
    private Integer number;


    @CreatedDate
    @Column(nullable = false)
    private Date createdAt;


    @LastModifiedDate
    @Column(nullable = false)
    private Date updatedAt;


/*
    private List<Answer> answers;
    private Agent buySideAgent;
 */
}
