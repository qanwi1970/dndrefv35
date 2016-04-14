package com.dungeonmart.ref.v35.seeds;

import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
public class SeedEquipment {
    private int id;
    private String name;
    private String family;
    private String category;
    private String subcategory;
    private String cost;
    private String dmg_s;
    private String armor_shield_bonus;
    private String maximum_dex_bonus;
    private String dmg_m;
    private String weight;
    private String critical;
    private String armor_check_penalty;
    private String arcane_spell_failure_chance;
    private String range_increment;
    private String speed_30;
    private String type;
    private String speed_20;
    private String full_text;
    private String reference;
}
