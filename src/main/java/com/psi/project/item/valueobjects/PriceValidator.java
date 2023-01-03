package com.psi.project.item.valueobjects;

import com.psi.project.core.interfaces.CoreValidator;
import com.psi.project.item.exceptions.IllegalPriceException;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Embeddable
@NotNull
@NoArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PriceValidator implements CoreValidator {

    @Column
    Double price;

    public PriceValidator(Double price) {
        if( Objects.isNull(price) )
            throw new IllegalPriceException("Price is necessary!");
        if( price < 0L )
            throw new IllegalPriceException("Price can not be less than 0!");
        this.price = price;
    }

    public double toDouble() {
        return this.price;
    }

    @Override
    public String toString() {
        return price.toString();
    }
}
