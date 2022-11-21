package com.psi.project.items.valueobjects;

import com.psi.project.core.interfaces.CoreValidator;
import com.psi.project.items.exceptions.IllegalItemArgumentException;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PriceValidator implements CoreValidator {

    Double price;

    public PriceValidator(Double price) {
        if( Objects.isNull(price) )
            throw new IllegalItemArgumentException("PRICE can not be null !!");
        if( price < 0L )
            throw new IllegalItemArgumentException("PRICE CANNOT BE LESS THAN 0 !!");
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
