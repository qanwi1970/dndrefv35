package com.dungeonmart.ref.v35.repositories;

import com.dungeonmart.ref.v35.entities.Feat;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface FeatRepository extends PagingAndSortingRepository<Feat, UUID> {
}
