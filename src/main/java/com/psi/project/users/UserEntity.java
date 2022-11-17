package com.psi.project.users;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.psi.project.address.AddressEntity;
import com.psi.project.basic.BasicEntity;
import com.psi.project.items.ItemEntity;
import com.psi.project.users.valueobjects.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * Encja użytkownika systemu
 * @author Igor Kawczyński
 *
 */
@Table(name = "users")
@Getter
@Setter
@Entity
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity extends BasicEntity {

    @Embedded
    @Column(unique = true)
    EmailValidator email;
    @Embedded
    NameValidator username;
    @Embedded
    PasswordValidator password;
    @Embedded
    PeselValidator pesel;
    @Enumerated(EnumType.STRING)
    TypeValidator type;
    @OneToOne(mappedBy = "userId", fetch = FetchType.LAZY)
    @JsonBackReference
    AddressEntity addressId;

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
    @JsonBackReference
    List<ItemEntity> itemsEntities;

    @Builder
    public UserEntity(
            EmailValidator email,
            NameValidator username,
            PasswordValidator password,
            PeselValidator pesel,
            TypeValidator type,
            AddressEntity addressId
    ) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.pesel = pesel;
        this.type = type;
        this.addressId = addressId;
    }
}
