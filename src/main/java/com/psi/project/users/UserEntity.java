package com.psi.project.users;

import com.psi.project.items.ItemEntity;
import com.psi.project.users.valueobjects.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
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
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class UserEntity{


    @Id
    Integer id;
    @Embedded
    @Column(unique = true)
    EmailValidator email;
    @Embedded
    NameValidator name;
    @Embedded
    PasswordValidator password;
    @Embedded
    PeselValidator pesel;
    @Embedded
    TypeValidator type;

    @OneToMany(mappedBy = "itemId", fetch = FetchType.LAZY)
    List<ItemEntity> itemsEntities;

    @Builder
    public UserEntity(
            EmailValidator email,
            NameValidator name,
            PasswordValidator password,
            PeselValidator pesel,
            TypeValidator type
    ) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.pesel = pesel;
        this.type = type;
    }
}
