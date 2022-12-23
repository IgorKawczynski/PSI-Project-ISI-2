package com.psi.project.user.exceptions;


public class IllegalPasswordException extends IllegalArgumentException{

    public IllegalPasswordException(String s) {
        super(s);
    }
}