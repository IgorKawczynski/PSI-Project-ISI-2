package com.psi.project.user;

import com.psi.project.user.valueobjects.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "USER")
@Getter
@Setter
@RequiredArgsConstructor
public class UserEntity {

    @Embedded
    @Column(unique = true)
    private EmailValidator email;
    @Embedded
    @AttributeOverrides( {@AttributeOverride(name = "name", column = @Column(name = "first_name"))} )
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
