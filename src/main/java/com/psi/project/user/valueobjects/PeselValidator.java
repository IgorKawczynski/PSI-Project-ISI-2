package com.psi.project.user.valueobjects;

import com.psi.project.core.interfaces.CoreValidator;
import com.psi.project.user.exceptions.IllegalPeselException;
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
public class PeselValidator implements CoreValidator {

    @Column
    private String pesel;

    public PeselValidator(String pesel) {
        if ( Objects.isNull(pesel) )
            throw new IllegalPeselException("Pesel is necessary!");
        if ( pesel.isEmpty() )
            throw new IllegalPeselException("Pesel can not be empty!");
        if ( !(pesel.length() == 11) )
            throw new IllegalPeselException("Pesel must have exactly 11 digits!");
        if ( pesel.contains(DIGITS) )
            throw new IllegalPeselException("Pesel may contain only digits!");
        this.pesel = pesel;
    }

    @Override
    public String toString() {
        return pesel;
    }
}
