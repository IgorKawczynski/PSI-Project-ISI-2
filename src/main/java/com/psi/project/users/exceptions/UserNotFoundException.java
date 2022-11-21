package com.psi.project.users.exceptions;

public class UserNotFoundException extends NoSuchFieldException {

    public UserNotFoundException(String s) {
        super(s);
    }
}
