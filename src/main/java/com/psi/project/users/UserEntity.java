package com.psi.project.users;

import com.psi.project.basic.BasicEntity;
import com.psi.project.users.valueobjects.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 *
 * Encja użytkownika systemu
 *
 */
@Table(name = "USERS")
@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class UserEntity extends BasicEntity {

    @Embedded
    @Column(unique = true)
    private EmailValidator email;
    @Embedded
    private NameValidator name;
    @Embedded
    private PasswordValidator password;
    @Embedded
    private PeselValidator pesel;
    @Embedded
    private TypeValidator type;

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
