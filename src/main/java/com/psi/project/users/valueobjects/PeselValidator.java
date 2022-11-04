package com.psi.project.users.valueobjects;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Embeddable
@ToString
@NotNull
@NoArgsConstructor
@EqualsAndHashCode
public class PeselValidator {

    private static final String DIGITS = "[0-9]+";

    @Column
    private String pesel;

    public PeselValidator(String pesel) {
        if ( Objects.isNull(pesel) )
            throw new IllegalArgumentException("Pesel can't be null!");
        if ( !(pesel.length() == 11) )
            throw new IllegalStateException("Pesel must have 11 digits!");
        if ( !pesel.contains(DIGITS) )
            throw new IllegalArgumentException("Pesel may contain only digits!");
        this.pesel = pesel;
    }
}
