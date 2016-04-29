package com.dungeonmart.ref.v35.seeds;

import com.dungeonmart.ref.v35.entities.Spell;
import com.dungeonmart.ref.v35.repositories.SkillRepository;
import com.dungeonmart.ref.v35.repositories.SpellRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.apache.commons.lang3.StringEscapeUtils.unescapeHtml4;

@Data
@NoArgsConstructor
@Slf4j
public class SeedSpell {
    private int id;

    private String name;

    private String altname;

    private String school;

    private String subschool;

    private String descriptor;

    private String spellcraft_dc;

    private String level;

    private String components;

    private String casting_time;

    private String range;

    private String target;

    private String area;

    private String effect;

    private String duration;

    private String saving_throw;

    private String spell_resistance;

    private String short_description;

    private String to_develop;

    private String material_components;

    private String arcane_material_components;

    private String focus;

    private String description;

    private String xp_cost;

    private String arcane_focus;

    private String wizard_focus;

    private String verbal_components;

    private String sorcerer_focus;

    private String bard_focus;

    private String cleric_focus;

    private String druid_focus;

    private String full_text;

    private String reference;

    public void loadSpells(SpellRepository spellRepository) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/seed/spell.json");
        List<SeedSpell> seedSpells = mapper.readValue(resourceAsStream, new TypeReference<List<SeedSpell>>() {
        });
        for (SeedSpell seedSpell : seedSpells) {
            log.debug(seedSpell.name);
            Spell spell = Spell.builder()
                    .name(seedSpell.name)
                    .altname(seedSpell.altname)
                    .school(seedSpell.school)
                    .subschool(seedSpell.subschool)
                    .descriptor(seedSpell.descriptor)
                    .spellcraftDC(seedSpell.spellcraft_dc)
                    .level(seedSpell.level)
                    .components(seedSpell.components)
                    .castingTime(seedSpell.casting_time)
                    .range(seedSpell.range)
                    .target(seedSpell.target)
                    .area(seedSpell.area)
                    .effect(seedSpell.effect)
                    .duration(seedSpell.duration)
                    .savingThrow(seedSpell.saving_throw)
                    .spellResistance(seedSpell.spell_resistance)
                    .shortDescription(seedSpell.short_description)
                    .toDevelop(seedSpell.to_develop)
                    .materialComponents(seedSpell.material_components)
                    .arcaneMaterialComponents(seedSpell.arcane_material_components)
                    .focus(seedSpell.focus)
                    .description(unescapeHtml4(seedSpell.description))
                    .xpCost(seedSpell.xp_cost)
                    .arcaneFocus(seedSpell.arcane_focus)
                    .wizardFocus(seedSpell.wizard_focus)
                    .verbalComponents(seedSpell.verbal_components)
                    .sorcererFocus(seedSpell.sorcerer_focus)
                    .bardFocus(seedSpell.bard_focus)
                    .clericFocus(seedSpell.cleric_focus)
                    .druidFocus(seedSpell.druid_focus)
                    .fullText(unescapeHtml4(seedSpell.full_text))
                    .reference(seedSpell.reference)
                    .seedData(true)
                    .build();
            spellRepository.save(spell);
        }
    }
}
