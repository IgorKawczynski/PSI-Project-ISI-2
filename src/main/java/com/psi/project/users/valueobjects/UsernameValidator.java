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
@NoArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UsernameValidator implements CoreValidator {
    @Column
    String username;
    public UsernameValidator(String username) {
        if( Objects.isNull(username) )
            throw new IllegalNameException("USERNAME CANNOT BE NULL !!");
        if( !containsValidCharacters(username) )
            throw new IllegalNameException("USERNAME MAY CONTAIN ONLY ENGLISH ALPHABET, NUMBERS, SPECIAL CHARACTERS !!");
        if( !isValidLength(username, 1, 30) )
            throw new IllegalNameException("USERNAME MUST BE BETWEEN 1 AND 30 CHARACTERS !!");
        this.username = username;
    }

    @Override
    public String toString() {
        return username;
    }
}
