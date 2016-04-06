package com.dungeonmart.ref.v35.controllers;

import com.dungeonmart.ref.v35.entities.ClassCharacter;
import com.dungeonmart.ref.v35.entities.ClassLevel;
import com.dungeonmart.ref.v35.seeds.SeedClass;
import com.dungeonmart.ref.v35.seeds.SeedClassLevel;
import com.dungeonmart.ref.v35.repositories.ClassLevelRepository;
import com.dungeonmart.ref.v35.repositories.ClassRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.apache.commons.lang3.StringEscapeUtils.unescapeHtml4;

@Slf4j
@RestController
@RequestMapping("/seed")
public class ClassSeedController {

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private ClassLevelRepository classLevelRepository;

    @RequestMapping(path = "/class", method = RequestMethod.POST)
    public HttpEntity seedClasses() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/seed/classes.json");
        List<SeedClass> seedClasses = mapper.readValue(resourceAsStream, new TypeReference<List<SeedClass>>() {
        });
        for (SeedClass seedClass : seedClasses) {
            log.info(seedClass.getName());
            ClassCharacter classCharacter = ClassCharacter.builder()
                    .name(seedClass.getName())
                    .type(seedClass.getType())
                    .alignment(seedClass.getAlignment())
                    .hitDie(seedClass.getHit_die())
                    .classSkills(seedClass.getClass_skills())
                    .skillPoints(seedClass.getSkill_points())
                    .skillPointsAbility(seedClass.getSkill_points_ability())
                    .spellStat(seedClass.getSpell_stat())
                    .proficiencies(seedClass.getProficiencies())
                    .spellType(seedClass.getSpell_type())
                    .epicFeatBaseLevel(seedClass.getEpic_feat_base_level())
                    .epicFeatInterval(seedClass.getEpic_feat_interval())
                    .epicFeatList(seedClass.getEpic_feat_list())
                    .epicFullText(unescapeHtml4(seedClass.getEpic_full_text()))
                    .requiredRace(seedClass.getReq_race())
                    .requiredWeaponProficiency(seedClass.getReq_weapon_proficiency())
                    .requiredBaseAttackBonus(seedClass.getReq_base_attack_bonus())
                    .requiredSkill(seedClass.getReq_skill())
                    .requiredFeat(seedClass.getReq_feat())
                    .requiredSpells(seedClass.getReq_spells())
                    .requiredLanguages(seedClass.getReq_languages())
                    .requiredPsionics(seedClass.getReq_psionics())
                    .requiredEpicFeat(seedClass.getReq_epic_feat())
                    .requiredSpecial(seedClass.getReq_special())
                    .spellList1(seedClass.getSpell_list_1())
                    .spellList2(seedClass.getSpell_list_2())
                    .spellList3(seedClass.getSpell_list_3())
                    .spellList4(seedClass.getSpell_list_4())
                    .spellList5(seedClass.getSpell_list_5())
                    .fullText(unescapeHtml4(seedClass.getFull_text()))
                    .reference(seedClass.getReference())
                    .seedData(true)
                    .build();
            classRepository.save(classCharacter);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(path = "/table", method = RequestMethod.POST)
    public HttpEntity seedClassTables() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/seed/classlevel.json");
        List<SeedClassLevel> seedClassLevels = mapper.readValue(resourceAsStream, new TypeReference<List<SeedClassLevel>>() {});
        for (SeedClassLevel seedClassLevel : seedClassLevels) {
            log.info(seedClassLevel.getName() + ":" + seedClassLevel.getLevel());
            ClassLevel classLevel = ClassLevel.builder()
                    .name(seedClassLevel.getName())
                    .level(seedClassLevel.getLevel())
                    .baseAttackBonus(seedClassLevel.getBase_attack_bonus())
                    .fortitudeSave(seedClassLevel.getFort_save())
                    .reflexSave(seedClassLevel.getRef_save())
                    .willSave(seedClassLevel.getWill_save())
                    .casterLevel(seedClassLevel.getCaster_level())
                    .pointsPerDay(seedClassLevel.getPoints_per_day())
                    .acBonus(seedClassLevel.getAc_bonus())
                    .flurryOfBlows(seedClassLevel.getFlurry_of_blows())
                    .bonusSpells(seedClassLevel.getBonus_spells())
                    .powersKnown(seedClassLevel.getPowers_known())
                    .unarmoredSpeedBonus(seedClassLevel.getUnarmored_speed_bonus())
                    .unarmedDamage(seedClassLevel.getUnarmed_damage())
                    .powerLevel(seedClassLevel.getPower_level())
                    .special(seedClassLevel.getSpecial())
                    .spellSlots0(seedClassLevel.getSlots_0())
                    .spellSlots1(seedClassLevel.getSlots_1())
                    .spellSlots2(seedClassLevel.getSlots_2())
                    .spellSlots3(seedClassLevel.getSlots_3())
                    .spellSlots4(seedClassLevel.getSlots_4())
                    .spellSlots5(seedClassLevel.getSlots_5())
                    .spellSlots6(seedClassLevel.getSlots_6())
                    .spellSlots7(seedClassLevel.getSlots_7())
                    .spellSlots8(seedClassLevel.getSlots_8())
                    .spellSlots9(seedClassLevel.getSlots_9())
                    .spellsKnown0(seedClassLevel.getSpells_known_0())
                    .spellsKnown1(seedClassLevel.getSpells_known_1())
                    .spellsKnown2(seedClassLevel.getSpells_known_2())
                    .spellsKnown3(seedClassLevel.getSpells_known_3())
                    .spellsKnown4(seedClassLevel.getSpells_known_4())
                    .spellsKnown5(seedClassLevel.getSpells_known_5())
                    .spellsKnown6(seedClassLevel.getSpells_known_6())
                    .spellsKnown7(seedClassLevel.getSpells_known_7())
                    .spellsKnown8(seedClassLevel.getSpells_known_8())
                    .spellsKnown9(seedClassLevel.getSpells_known_9())
                    .reference(seedClassLevel.getReference())
                    .seedData(true)
                    .build();
            classLevelRepository.save(classLevel);
        }

        return new ResponseEntity(HttpStatus.OK);
    }
}
