package com.psi.project.items.valueobjects;

import com.psi.project.core.interfaces.CoreValidator;
import com.psi.project.items.exceptions.IllegalItemArgumentException;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ItemNameValidator implements CoreValidator {

    @Column(name = "item_name")
    String itemName;

    public ItemNameValidator(String itemName) {
        if( Objects.isNull(itemName) )
            throw new IllegalItemArgumentException("NAME CANNOT BE NULL !!");
        if( !containsPolishCharacters(itemName) )
            throw new IllegalItemArgumentException("NAME MAY CONTAIN ONLY POLISH CHARACTERS !!");
        if( !isValidLength(itemName, 1, 30) )
            throw new IllegalItemArgumentException("NAME MUST BE BETWEEN 1 AND 30 CHARACTERS !!");
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return itemName;
    }


}
