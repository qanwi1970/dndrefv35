package com.dungeonmart.ref.v35.seeds;

import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
public class SeedFeat {

    private int id;

    private String name;

    private String type;

    private String multiple;

    private String stack;

    private String choice;

    private String prerequisite;

    private String benefit;

    private String normal;

    private String special;

    private String full_text;

    private String reference;

}
