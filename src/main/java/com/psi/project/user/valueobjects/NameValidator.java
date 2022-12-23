package com.psi.project.user.valueobjects;

import com.psi.project.core.interfaces.CoreValidator;
import com.psi.project.user.exceptions.IllegalNameException;
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
public class NameValidator implements CoreValidator {
    @Column
    String name;
    public NameValidator(String name) {
        if( Objects.isNull(name) )
            throw new IllegalNameException("Name is necessary!");
        if( name.isEmpty() )
            throw new IllegalNameException("Name can not be empty!");
        if( !isValidLength(name, 3, 80) )
            throw new IllegalNameException("Name must be between 3 and 80 characters!");
        if( !containsPolishCharacters(name) )
            throw new IllegalNameException("Name may contain only letters!");

        name = toLowerCaseThenCapitalize(name);
        this.name = name;
    }

    public String toLowerCaseThenCapitalize(String string){
        return string.substring(0,1).toUpperCase() + string.substring(1).toLowerCase();
    }

    @Override
    public String toString() {
        return name;
    }
}
