package com.psi.project.address.valueobjects;

import com.psi.project.address.exceptions.IllegalZipCodeException;
import com.psi.project.core.interfaces.CoreValidator;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Embeddable
@NotNull
@NoArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ZipCodeValidator implements CoreValidator {

    private static final String ZIPCODE_PATTERN = "^[0-9]{2}(?:-[0-9]{3})?$";

    String zipCode;

    public ZipCodeValidator(String zipCode) {
        if(Objects.isNull(zipCode) )
            throw new IllegalZipCodeException("Zip code is necessary!");
        if( zipCode.isEmpty() )
            throw new IllegalZipCodeException("Zip code can not be empty!");
        if( !isValidLength(zipCode, 6, 6) )
            throw new IllegalZipCodeException("Zip code must have exactly 6 characters!");
        if( !matchesPattern(zipCode, ZIPCODE_PATTERN) )
            throw new IllegalZipCodeException("Zip code must contain 2 digits - 3 digits (E.g. 99-999");
        this.zipCode = zipCode;
    }

    @Override
    public String toString(){ return zipCode; }

}
