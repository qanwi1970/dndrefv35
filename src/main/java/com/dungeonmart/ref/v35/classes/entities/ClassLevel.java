package com.dungeonmart.ref.v35.classes.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
public class ClassLevel {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID classLevelId;

    private String name;

    private int level;

    private String baseAttackBonus;

    private String fortitudeSave;

    private String reflexSave;

    private String willSave;

    private String casterLevel;

    private String pointsPerDay;

    private String acBonus;

    private String flurryOfBlows;

    private String bonusSpells;

    private String powersKnown;

    private String unarmoredSpeedBonus;

    private String unarmedDamage;

    private String powerLevel;

    private String special;

    private String spellSlots0;

    private String spellSlots1;

    private String spellSlots2;

    private String spellSlots3;

    private String spellSlots4;

    private String spellSlots5;

    private String spellSlots6;

    private String spellSlots7;

    private String spellSlots8;

    private String spellSlots9;

    private String spellsKnown0;

    private String spellsKnown1;

    private String spellsKnown2;

    private String spellsKnown3;

    private String spellsKnown4;

    private String spellsKnown5;

    private String spellsKnown6;

    private String spellsKnown7;

    private String spellsKnown8;

    private String spellsKnown9;

    private String reference;

}
