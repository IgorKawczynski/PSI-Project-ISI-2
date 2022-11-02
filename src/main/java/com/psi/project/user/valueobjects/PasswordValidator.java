package com.psi.project.user.valueobjects;

import com.psi.project.user.exceptions.IllegalEmailException;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

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
public class PasswordValidator {
    String password;

    public PasswordValidator(String password) {
        if(Objects.isNull(password))
            throw new IllegalEmailException("Password is necessary !!");
        if(password.isEmpty())
            throw new IllegalEmailException("Password cannot be empty !!");
        if(password.length() < 8)
            throw new IllegalEmailException("Password must contain at least 7 characters !!");
        this.password = password;
    }
}
