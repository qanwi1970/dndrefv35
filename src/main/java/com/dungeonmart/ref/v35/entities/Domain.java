package com.dungeonmart.ref.v35.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.UUID;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Domain {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID domainId;

    private String name;

    private String grantedPowers;

    private String spell1;

    private String spell2;

    private String spell3;

    private String spell4;

    private String spell5;

    private String spell6;

    private String spell7;

    private String spell8;

    private String spell9;

    @Column(columnDefinition = "TEXT")
    private String fullText;

    private String reference;

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @CreatedDate
    @Column(updatable = false)
    private long createdDate;

    @LastModifiedBy
    private String modifiedBy;

    @LastModifiedDate
    private long modifiedDate;

    private boolean seedData;
}
