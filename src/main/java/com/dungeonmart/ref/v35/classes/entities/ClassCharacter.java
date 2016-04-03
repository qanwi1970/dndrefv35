package com.dungeonmart.ref.v35.classes.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@EntityListeners(AuditingEntityListener.class)
public class ClassCharacter implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID classCharacterId;

    @NotBlank
    private String name;

    private String type;

    private String alignment;

    private String hitDie;

    @Column(length = 512)
    private String classSkills;

    private String skillPoints;

    private String skillPointsAbility;

    private String spellStat;

    @Column(length = 1024)
    private String proficiencies;

    private String spellType;

    private String epicFeatBaseLevel;

    private String epicFeatInterval;

    @Column(length = 1024)
    private String epicFeatList;

    @Column(columnDefinition = "TEXT")
    private String epicFullText;

    private String requiredRace;

    private String requiredWeaponProficiency;

    private String requiredBaseAttackBonus;

    private String requiredSkill;

    private String requiredFeat;

    private String requiredSpells;

    private String requiredLanguages;

    private String requiredPsionics;

    private String requiredEpicFeat;

    private String requiredSpecial;

    @Column(length = 512)
    private String spellList1;

    private String spellList2;

    private String spellList3;

    private String spellList4;

    private String spellList5;

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
