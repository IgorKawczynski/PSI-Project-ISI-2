package com.psi.project.users.valueobjects;

import com.psi.project.core.interfaces.CoreValidator;
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
public class NameValidator implements CoreValidator {
    @Column
    String username;
    public NameValidator(String username) {
        if( Objects.isNull(username) )
            throw new IllegalNameException("NAME CANNOT BE NULL !!");
        if( !containsPolishCharacters(username) )
            throw new IllegalNameException("NAME MAY CONTAIN ONLY POLISH CHARACTERS !!");
        if( !isValidLength(username, 1, 30) )
            throw new IllegalNameException("NAME MUST BE BETWEEN 1 AND 30 CHARACTERS !!");
        this.username = username;
    }


}
