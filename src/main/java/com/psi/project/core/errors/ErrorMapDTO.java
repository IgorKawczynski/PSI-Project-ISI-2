package com.psi.project.core.errors;

import java.util.HashMap;
import java.util.Map;

/**
 * Bazowa mapa do obłużenia wyjątków
 * @author Igor Kawczynski
 */

public class ErrorMapDTO {

    Map<String, Exception> errorMap;

    public ErrorMapDTO(Map<String, Exception> errors) {
        this.errorMap = errors;
    }

    public boolean isEmpty() {
        return errorMap.isEmpty();
    }

    public void add(String fieldName, Exception exception) {
        errorMap.put(fieldName, exception);
    }

    public Map<String, String> getErrors() {
        HashMap<String, String> fieldNameAndMessage = new HashMap<>();
        this.errorMap.forEach((fieldName, exception) -> {
            fieldNameAndMessage.put(fieldName, exception.getMessage());
        });
        return fieldNameAndMessage;
    }
}