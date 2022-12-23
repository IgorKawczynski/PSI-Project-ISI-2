package com.psi.project.user.exceptions;

public class IllegalPeselException extends IllegalArgumentException{

    public IllegalPeselException(String s) {
        super(s);
    }
}