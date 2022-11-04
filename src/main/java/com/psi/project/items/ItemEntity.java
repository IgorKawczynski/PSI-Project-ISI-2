package com.psi.project.items;


import com.psi.project.basic.BasicEntity;
import com.psi.project.items.valueobjects.DescriptionValidator;
import com.psi.project.items.valueobjects.PriceValidator;
import com.psi.project.users.valueobjects.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * Encja przedmiotów sprzedaży
 *
 */
@Table(name = "ITEMS")
@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class ItemEntity extends BasicEntity {

    @Embedded
    NameValidator name;
    @Embedded
    DescriptionValidator description;
    @Embedded
    PriceValidator price;

    @Builder
    public ItemEntity(
            NameValidator name,
            DescriptionValidator description,
            PriceValidator price
    ) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
