package com.psi.project.items.valueobjects;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.Embeddable;

@Embeddable
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PriceValidator {

    Double price;

    public PriceValidator(Double price) {
        this.price = price;
    }

    public double toDouble() {
        return this.price;
    }
}
