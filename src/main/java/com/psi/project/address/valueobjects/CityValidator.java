package com.psi.project.address.valueobjects;

import com.psi.project.address.exceptions.IllegalCityException;
import com.psi.project.core.interfaces.CoreValidator;
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
public class CityValidator implements CoreValidator {

    @Column
    String city;

    public CityValidator(String city) {
        if (Objects.isNull(city))
            throw new IllegalCityException("City is necessary!");
        if (city.isEmpty())
            throw new IllegalCityException("City can not be empty!");
        if (!isValidLength(city, 2, 45))
            throw new IllegalCityException("City must be between 2 and 45 characters length");
        if (!containsPolishCharacters(city))
            throw new IllegalCityException("City may contain only letters!");

        city = toLowerCaseThenCapitalize(city);
        this.city = city;
    }

    @Override
    public String toString() { return city; }
}

