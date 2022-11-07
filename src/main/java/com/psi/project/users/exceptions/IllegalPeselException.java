package com.psi.project.users.exceptions;

public class IllegalPeselException extends IllegalArgumentException{

    public IllegalPeselException(String s) {
        super(s);
    }
}