package com.psi.project.user.valueobjects;

import com.psi.project.core.interfaces.CoreValidator;

import com.psi.project.user.exceptions.IllegalEmailException;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.util.Objects;


@Embeddable
@NotNull
@NoArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmailValidator implements CoreValidator{

    private static final String EMAIL_PATTERN = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+" +
            "(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]" +
            "|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)" +
            "+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}" +
            "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\" +
            "x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])";
    String email;

    public EmailValidator(String email) {
        if( Objects.isNull(email) )
            throw new IllegalEmailException("E-mail is necessary!");
        if( email.isEmpty() )
            throw new IllegalEmailException("E-mail can not be empty!");
        if ( !isValidLength(email, 5, 50) )
            throw new IllegalEmailException("E-mail must be between 5 and 50 characters length!");
        if( !matchesPattern(email, EMAIL_PATTERN) )
            throw new IllegalEmailException("Email may contain only letters, digits, and '@' '.' signs!");
        this.email = email;
    }

    @Override
    public boolean matchesPattern(String stringToCheck, String pattern) {
        stringToCheck = stringToCheck.toLowerCase();
        return CoreValidator.super.matchesPattern(stringToCheck, pattern);
    }
    @Override
    public String toString() {
        return email;
    }
}
