package com.psi.project.address.valueobjects;

import com.psi.project.address.exceptions.IllegalStreetException;
import com.psi.project.core.interfaces.CoreValidator;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StreetValidator implements CoreValidator {

    String street;

    public StreetValidator(String street) {
        if( !isValidLength(street, 0, 60) )
            throw new IllegalStreetException("Street must be between 0 and 60 characters length");
        if( !containsPolishCharacters(street) )
            throw new IllegalStreetException("Street may contain only letters!");

        street = toLowerCaseThenCapitalize(street);
        this.street = street;
    }

    @Override
    public String toString() { return street; }
}
