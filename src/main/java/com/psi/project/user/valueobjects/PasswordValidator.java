package com.psi.project.user.valueobjects;

import com.psi.project.core.interfaces.CoreValidator;
import com.psi.project.user.exceptions.IllegalPasswordException;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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
            throw new IllegalPasswordException("Password is necessary!");
        if( password.isEmpty() )
            throw new IllegalPasswordException("Password can not be empty!");
        if( !isValidLength(password, 7, 255) )
            throw new IllegalPasswordException("Password must be between 7 and 255 characters length!");
        if( !containsValidCharacters(password) )
            throw new IllegalPasswordException("Password must contain english letters, numbers or special characters only!");
        this.password = password;
    }

    @Override
    public String toString() {
        return password;
    }
}
