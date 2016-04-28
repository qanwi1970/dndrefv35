package com.dungeonmart.ref.v35.seeds;

import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
public class SeedItem {
    private int id;

    private String name;

    private String category;

    private String subcategory;

    private String special_ability;

    private String aura;

    private String caster_level;

    private String price;

    private String manifester_level;

    private String prereq;

    private String cost;

    private String weight;

    private String full_text;

    private String reference;
}
