package com.dungeonmart.ref.v35.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.UUID;

@Data
@Builder
@ToString
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Item implements PagingAndSortingEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    private String name;

    private String category;

    private String subcategory;

    private String specialAbility;

    private String aura;

    private String casterLevel;

    private String price;

    private String manifesterLevel;

    private String preRequisites;

    private String cost;

    private String weight;

    @Column(columnDefinition = "TEXT")
    private String fullText;

    private String reference;

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @CreatedDate
    @Column(updatable = false)
    private long createdDate;

    @LastModifiedBy
    private String modifiedBy;

    @LastModifiedDate
    private long modifiedDate;

    private boolean seedData;
}
