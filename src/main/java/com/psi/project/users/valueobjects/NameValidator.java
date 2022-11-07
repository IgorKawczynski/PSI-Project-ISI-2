package com.psi.project.users.valueobjects;

import com.psi.project.basic.interfaces.BasicValidator;
import com.psi.project.users.exceptions.IllegalNameException;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NameValidator implements BasicValidator {

    @Column
    String name;

    public NameValidator(String name) {
        if( Objects.isNull(name) )
            throw new IllegalNameException("NAME CANNOT BE NULL !!");
        if( !containsPolishCharacters(name) )
            throw new IllegalNameException("NAME MAY CONTAIN ONLY POLISH CHARACTERS !!");
        if( !isValidLength(name, 1, 30) )
            throw new IllegalNameException("NAME MUST BE BETWEEN 1 AND 30 CHARACTERS !!");
        this.name = name;
    }


}
