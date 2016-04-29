package com.dungeonmart.ref.v35.seeds;

import com.dungeonmart.ref.v35.entities.Skill;
import com.dungeonmart.ref.v35.repositories.PowerRepository;
import com.dungeonmart.ref.v35.repositories.SkillRepository;
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
public class SeedSkill {
    private int id;

    private String name;

    private String subtype;

    private String key_ability;

    private String psionic;

    private String trained;

    private String armor_check;

    private String description;

    private String skill_check;

    private String action;

    private String try_again;

    private String special;

    private String restriction;

    private String synergy;

    private String epic_use;

    private String untrained;

    private String full_text;

    private String reference;


    public void loadSkills(SkillRepository skillRepository) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/seed/skill.json");
        List<SeedSkill> seedSkills = mapper.readValue(resourceAsStream, new TypeReference<List<SeedSkill>>() {
        });
        for (SeedSkill seedSkill : seedSkills) {
            log.debug(seedSkill.name);
            Skill skill = Skill.builder()
                    .name(seedSkill.name)
                    .subtype(seedSkill.subtype)
                    .keyAbility(seedSkill.key_ability)
                    .psionic(seedSkill.psionic)
                    .trained(seedSkill.trained)
                    .armorCheck(seedSkill.armor_check)
                    .description(unescapeHtml4(seedSkill.description))
                    .skillCheck(unescapeHtml4(seedSkill.skill_check))
                    .action(seedSkill.action)
                    .tryAgain(seedSkill.try_again)
                    .special(seedSkill.special)
                    .restriction(seedSkill.restriction)
                    .synergy(seedSkill.synergy)
                    .epicUse(unescapeHtml4(seedSkill.epic_use))
                    .untrained(seedSkill.untrained)
                    .fullText(unescapeHtml4(seedSkill.full_text))
                    .reference(seedSkill.reference)
                    .seedData(true)
                    .build();
            skillRepository.save(skill);
        }
    }
}
