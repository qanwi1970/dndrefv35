package com.dungeonmart.ref.v35.classes.entities;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class SeedClass {
    private int id;
    private String name;
    private String type;
    private String alignment;
    private String hit_die;
    private String class_skills;
    private String skill_points;
    private String skill_points_ability;
    private String spell_stat;
    private String proficiencies;
    private String spell_type;
    private String epic_feat_base_level;
    private String epic_feat_interval;
    private String epic_feat_list;
    private String epic_full_text;
    private String req_race;
    private String req_weapon_proficiency;
    private String req_base_attack_bonus;
    private String req_skill;
    private String req_feat;
    private String req_spells;
    private String req_languages;
    private String req_psionics;
    private String req_epic_feat;
    private String req_special;
    private String spell_list_1;
    private String spell_list_2;
    private String spell_list_3;
    private String spell_list_4;
    private String spell_list_5;
    private String full_text;
    private String reference;
}
