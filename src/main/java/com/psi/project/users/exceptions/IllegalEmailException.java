package com.psi.project.users.exceptions;

public class IllegalEmailException extends IllegalArgumentException{


    //Do poprawki -> własny message + defaultowy z IllegalArgumentException
    public IllegalEmailException(String s) {
        super(s);
    }
}
