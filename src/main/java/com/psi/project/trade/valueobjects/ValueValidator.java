package com.psi.project.trade.valueobjects;

import com.psi.project.core.interfaces.CoreValidator;
import com.psi.project.trade.exceptions.IllegalValueException;
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
public class ValueValidator implements CoreValidator {

    @Column
    Double value;

    public ValueValidator(Double value) {
        if( Objects.isNull(value) )
            throw new IllegalValueException("Value is necessary!");
        if( value < 0L )
            throw new IllegalValueException("Value can not be less than 0!");
        this.value = value;
    }

    public double toDouble() {
        return this.value;
    }

    @Override
    public String toString() { return value.toString(); }
}
