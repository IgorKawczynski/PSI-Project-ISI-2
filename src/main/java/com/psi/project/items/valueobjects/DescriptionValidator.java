package com.psi.project.items.valueobjects;

import com.psi.project.core.interfaces.CoreValidator;
import com.psi.project.items.exceptions.IllegalDescriptionException;
import com.psi.project.items.exceptions.IllegalItemArgumentException;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DescriptionValidator implements CoreValidator {

    String description;

    public DescriptionValidator(String description) {
        if( Objects.isNull(description) )
            throw new IllegalItemArgumentException("DESCRIPTION CANNOT BE NULL !!");
        if( !containsValidCharacters(description) )
            throw new IllegalItemArgumentException("DESCRIPTION MAY CONTAIN ONLY ENGLISH CHARACTERS !!");
        if( !isValidLength(description, 1, 255) )
            throw new IllegalItemArgumentException("DESCRIPTION MUST BE BETWEEN 1 AND 255 CHARACTERS !!");
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
