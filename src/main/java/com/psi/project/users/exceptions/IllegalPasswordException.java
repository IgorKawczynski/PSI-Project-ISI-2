package com.psi.project.users.exceptions;


public class IllegalPasswordException extends IllegalArgumentException{

    public IllegalPasswordException(String s) {
        super(s);
    }
}