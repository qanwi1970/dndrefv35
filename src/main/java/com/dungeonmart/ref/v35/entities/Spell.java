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
public class Spell implements PagingAndSortingEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    private String name;

    private String altname;

    private String school;

    private String subschool;

    private String descriptor;

    private String spellcraftDC;

    private String level;

    @Column(columnDefinition = "VARCHAR(512)")
    private String components;

    private String castingTime;

    private String range;

    private String target;

    private String area;

    private String effect;

    private String duration;

    private String savingThrow;

    private String spellResistance;

    private String shortDescription;

    @Column(columnDefinition = "VARCHAR(1024)")
    private String toDevelop;

    @Column(columnDefinition = "VARCHAR(512)")
    private String materialComponents;

    private String arcaneMaterialComponents;

    @Column(columnDefinition = "VARCHAR(512)")
    private String focus;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "VARCHAR(512)")
    private String xpCost;

    private String arcaneFocus;

    private String wizardFocus;

    private String verbalComponents;

    private String sorcererFocus;

    private String bardFocus;

    private String clericFocus;

    private String druidFocus;

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
