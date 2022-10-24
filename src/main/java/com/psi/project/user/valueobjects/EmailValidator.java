package com.psi.project.user.valueobjects;

import com.psi.project.user.exceptions.IllegalEmailException;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

import java.util.Objects;

public class EmailValidator {

    private static final String EMAIL_PATTERN = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+" +
            "(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]" +
            "|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)" +
            "+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}" +
            "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\" +
            "x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])";
    String email;


    public EmailValidator(String email) {
        if(Objects.isNull(email))
            throw new IllegalEmailException("Email is necessary !!");
        if(email.isEmpty())
            throw new IllegalEmailException("Email cannot be empty !!");
        if(email.length() < 6)
            throw new IllegalEmailException("Email must contain at least 5 characters !!");
        if(!email.contains(EMAIL_PATTERN))
            throw new IllegalEmailException("Email must contain '@' '.' 'a-z' characters!!");
        this.email = email;
    }
}