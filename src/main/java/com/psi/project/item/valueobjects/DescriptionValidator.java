package com.psi.project.item.valueobjects;

import com.psi.project.core.interfaces.CoreValidator;
import com.psi.project.item.exceptions.IllegalDescriptionException;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DescriptionValidator implements CoreValidator {

    @Column
    String description;

    public DescriptionValidator(String description) {
        if( !isValidLength(description, 0, 255) )
            throw new IllegalDescriptionException("Description must be between 0 and 255 characters length!");
        if( !containsValidCharacters(description) )
            throw new IllegalDescriptionException("Description may contain only english letters and special chars!");
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
