package com.psi.project.users;

import com.psi.project.items.ItemEntity;
import com.psi.project.users.valueobjects.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 *
 * Encja użytkownika systemu
 *
 */
@Table(name = "users")
@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class UserEntity{


    @Id
    private Integer id;
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

    @OneToMany(mappedBy = "itemId", fetch = FetchType.LAZY)
    private List<ItemEntity> itemsEntities;

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
