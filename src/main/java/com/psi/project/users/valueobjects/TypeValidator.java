package com.psi.project.users.valueobjects;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@ToString
public enum TypeValidator {

    @JsonProperty
    SUPERADMIN(),
    @JsonProperty
    ADMIN(),
    @JsonProperty
    CLIENT();

//    private final String name = "";

    @JsonCreator
    public static TypeValidator fromString(String string) {
        //TODO
        return null;
    }
}
