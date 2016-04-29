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
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Monster implements PagingAndSortingEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    private String family;

    private String name;

    private String altname;

    private String size;

    private String type;

    private String descriptor;

    private String hitDice;

    private String initiative;

    private String speed;

    private String armorClass;

    private String baseAttack;

    private String grapple;

    private String attack;

    private String fullAttack;

    private String space;

    private String reach;

    @Column(columnDefinition = "VARCHAR(512)")
    private String specialAttacks;

    @Column(columnDefinition = "VARCHAR(512)")
    private String specialQualities;

    private String saves;

    private String abilities;

    @Column(columnDefinition = "VARCHAR(512)")
    private String skills;

    private String bonusFeats;

    @Column(columnDefinition = "VARCHAR(512)")
    private String feats;

    @Column(columnDefinition = "VARCHAR(512)")
    private String epicFeats;

    private String environment;

    @Column(columnDefinition = "VARCHAR(512)")
    private String organization;

    private String challengeRating;

    private String treasure;

    private String alignment;

    private String advancement;

    private String levelAdjustment;

    @Column(columnDefinition = "VARCHAR(512)")
    private String specialAbilities;

    @Column(columnDefinition = "TEXT")
    private String statBlock;

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
