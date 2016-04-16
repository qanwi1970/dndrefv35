package com.dungeonmart.ref.v35.controllers;

import com.dungeonmart.ref.v35.entities.Domain;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Repository
@RequestMapping(path = "/feats")
public class FeatController extends PagingAndSortingController<Domain, UUID> {
}
