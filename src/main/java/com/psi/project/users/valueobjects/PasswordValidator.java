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
@ToString
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
            throw new IllegalPasswordException("Password is necessary !!");
        if( password.isEmpty() )
            throw new IllegalPasswordException("Password cannot be empty !!");
        if( password.length() < 8 )
            throw new IllegalPasswordException("Password must contain at least 7 characters !!");
        if( !containsValidCharacters(password, ENGLISH_LETTERS_NUMBERS_SPECIAL_CHARACTERS) )
            throw new IllegalPasswordException("Password must contain LETTERS, NUMBERS or SPECIAL characters only !!");
        this.password = password;
    }
}
