package com.psi.project.users.valueobjects;

import com.psi.project.core.interfaces.CoreValidator;
import com.psi.project.users.exceptions.IllegalPeselException;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Embeddable
@NotNull
@NoArgsConstructor
@EqualsAndHashCode
public class PeselValidator implements CoreValidator {

    @Column
    private String pesel;

    public PeselValidator(String pesel) {
        if ( Objects.isNull(pesel) )
            throw new IllegalPeselException("PESEL can not be null!");
        if ( !(pesel.length() == 11) )
            throw new IllegalPeselException("PESEL must have exactly 11 digits!");
        if ( pesel.contains(DIGITS) )
            throw new IllegalPeselException("PESEL may contain only digits!");
        this.pesel = pesel;
    }

    @Override
    public String toString() {
        return pesel;
    }
}
