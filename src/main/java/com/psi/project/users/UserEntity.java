package com.psi.project.users;

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
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity{

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
