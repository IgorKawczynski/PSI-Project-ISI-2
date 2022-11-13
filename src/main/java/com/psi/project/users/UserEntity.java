package com.psi.project.users;

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
@RequiredArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity implements Serializable {

    @Id
    Integer id;
    @Embedded
    @Column(unique = true)
    EmailValidator email;
    @Embedded
    NameValidator username;
    @Embedded
    PasswordValidator password;
    @Embedded
    PeselValidator pesel;
    @Embedded
    TypeValidator type;

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
    List<ItemEntity> itemsEntities;

    @Builder
    public UserEntity(
            EmailValidator email,
            NameValidator username,
            PasswordValidator password,
            PeselValidator pesel,
            TypeValidator type
    ) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.pesel = pesel;
        this.type = type;
    }
}
