package com.dungeonmart.ref.v35.repositories;

import com.dungeonmart.ref.v35.entities.Spell;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpellRepository extends PagingAndSortingRepository<Spell, UUID> {
}
