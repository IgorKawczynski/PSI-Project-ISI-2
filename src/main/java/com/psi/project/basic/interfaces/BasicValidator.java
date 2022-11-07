package com.psi.project.basic.interfaces;

/**
*
*  Bazowy Interfejs walidujący - dostarcza podstawowe metody walidujące
*   @author Igor Kawczyński
**/
public interface BasicValidator {

    String POLISH_ALPHABET = "[a-zA-Z-\\p{IsAlphabetic}]+";
    String ENGLISH_LETTERS_NUMBERS_SPECIAL_CHARACTERS = "[\\x21-\\x7E]+";

    default boolean containsValidCharacters(String stringToCheck, String pattern) {
        return stringToCheck.matches(pattern);
    }

    default boolean containsPolishCharacters(String stringToCheck) {
        return stringToCheck.matches(POLISH_ALPHABET);
    }

    default boolean isNumberBetween(Integer numberToCheck, int minimumLength, int maximumLength) {
        return numberToCheck > minimumLength - 1 && numberToCheck < maximumLength + 1;
    }

    default boolean isValidLength(String stringToCheck, int minimumLength, int maximumLength) {
        return stringToCheck.length() > minimumLength - 1 && stringToCheck.length() < maximumLength + 1;
    }


}
