package com.psi.project.users.valueobjects;

import com.psi.project.core.interfaces.CoreValidator;
import com.psi.project.users.exceptions.IllegalPasswordException;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Embeddable
@NotNull
@NoArgsConstructor
@EqualsAndHashCode
@Valid
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PasswordValidator implements CoreValidator {

    @Column
    String password;

    public PasswordValidator(String password) {
        if( Objects.isNull(password) )
            throw new IllegalPasswordException("PASSWORD is necessary !!");
        if( password.isEmpty() )
            throw new IllegalPasswordException("PASSWORD can not be empty !!");
        if( password.length() < 8 )
            throw new IllegalPasswordException("PASSWORD must contain at least 7 characters !!");
        if( !containsValidCharacters(password) )
            throw new IllegalPasswordException("PASSWORD must contain LETTERS, NUMBERS or SPECIAL characters only !!");
        this.password = password;
    }

    @Override
    public String toString() {
        return password;
    }
}
