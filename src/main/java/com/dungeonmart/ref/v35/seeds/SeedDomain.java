package com.dungeonmart.ref.v35.seeds;

import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
public class SeedDomain {
    private int id;
    private String name;
    private String granted_powers;
    private String spell_1;
    private String spell_2;
    private String spell_3;
    private String spell_4;
    private String spell_5;
    private String spell_6;
    private String spell_7;
    private String spell_8;
    private String spell_9;
    private String full_text;
    private String reference;
}
