package com.dungeonmart.ref.v35.seeds;

import com.dungeonmart.ref.v35.entities.Power;
import com.dungeonmart.ref.v35.repositories.PowerRepository;
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
public class SeedPower {
    private int id;

    private String name;

    private String discipline;

    private String subdiscipline;

    private String descriptor;

    private String level;

    private String display;

    private String manifesting_time;

    private String range;

    private String target;

    private String area;

    private String effect;

    private String duration;

    private String saving_throw;

    private String power_points;

    private String power_resistance;

    private String short_description;

    private String xp_cost;

    private String description;

    private String augment;

    private String full_text;

    private String reference;

    public void loadPowers(PowerRepository powerRepository) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/seed/power.json");
        List<SeedPower> seedPowers = mapper.readValue(resourceAsStream, new TypeReference<List<SeedPower>>(){});
        for (SeedPower seedPower : seedPowers) {
            log.debug(seedPower.getName());
            Power power = Power.builder()
                    .name(seedPower.name)
                    .discipline(seedPower.discipline)
                    .subdiscipline(seedPower.subdiscipline)
                    .descriptor(seedPower.descriptor)
                    .level(seedPower.level)
                    .display(seedPower.display)
                    .manifestingTime(seedPower.manifesting_time)
                    .range(seedPower.range)
                    .target(seedPower.target)
                    .area(seedPower.area)
                    .effect(seedPower.effect)
                    .duration(seedPower.duration)
                    .savingThrow(seedPower.saving_throw)
                    .powerPoints(seedPower.power_points)
                    .powerResistance(seedPower.power_resistance)
                    .shortDescription(seedPower.short_description)
                    .xpCost(seedPower.xp_cost)
                    .description(unescapeHtml4(seedPower.description))
                    .augment(seedPower.augment)
                    .fullText(unescapeHtml4(seedPower.full_text))
                    .reference(seedPower.reference)
                    .seedData(true)
                    .build();
            powerRepository.save(power);
        }
    }
}
