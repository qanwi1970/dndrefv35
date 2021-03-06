package com.dungeonmart.ref.v35.repositories;

import com.dungeonmart.ref.v35.entities.ClassCharacter;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RepositoryRestResource(collectionResourceRel = "classes", path = "classes")
public interface ClassRepository extends PagingAndSortingRepository<ClassCharacter, UUID> {
    Optional<ClassCharacter> findByName(String name);
}
