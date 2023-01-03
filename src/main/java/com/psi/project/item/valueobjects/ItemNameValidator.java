package com.psi.project.item.valueobjects;

import com.psi.project.core.interfaces.CoreValidator;
import com.psi.project.item.exceptions.IllegalItemNameException;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Embeddable
@NotNull
@NoArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ItemNameValidator implements CoreValidator {

    @Column(name = "item_name")
    String itemName;

    public ItemNameValidator(String itemName) {
        if( Objects.isNull(itemName) )
            throw new IllegalItemNameException("Item name is necessary!");
        if( itemName.isEmpty() )
            throw new IllegalItemNameException("Item name can not be empty");
        if( !isValidLength(itemName, 2, 60) )
            throw new IllegalItemNameException("Item name must be between 2 and 60 characters!");
        if( !containsPolishCharacters(itemName) )
            throw new IllegalItemNameException("Item name may contain only letters!");
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return itemName;
    }


}
