package com.psi.project.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.psi.project.address.AddressEntity;
import com.psi.project.core.CoreEntity;
import com.psi.project.item.ItemEntity;
import com.psi.project.trade.TradeEntity;
import com.psi.project.user.valueobjects.*;
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
@Table(name = "user")
@Getter
@Setter
@Entity
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity extends CoreEntity implements Serializable  {

    @Embedded
    @Column(unique = true)
    EmailValidator email;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "first_name"))
    })
    private NameValidator firstName;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "last_name"))
    })
    private NameValidator lastName;
    @Embedded
    PasswordValidator password;
    @Embedded
    PeselValidator pesel;
    @Enumerated(EnumType.STRING)
    TypeValidator type;
    @OneToOne(mappedBy = "userId", fetch = FetchType.LAZY)
    @JsonBackReference
    AddressEntity addressEntity;

    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    List<ItemEntity> itemEntities;

    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    List<TradeEntity> tradeEntities;

//    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
//    List<OpinionEntity> opinionEntities;

    @Builder
    public UserEntity(
            EmailValidator email,
            NameValidator firstName,
            NameValidator lastName,
            PasswordValidator password,
            PeselValidator pesel,
            TypeValidator type,
            AddressEntity addressEntity
    ) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.pesel = pesel;
        this.type = type;
        this.addressEntity = addressEntity;
    }
}
