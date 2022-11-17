package com.psi.project.address;

import com.psi.project.basic.BasicEntity;
import com.psi.project.users.UserEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;


@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
public class AddressEntity extends BasicEntity {

    String zipCode;
    String city;
    String street;

    @OneToOne
    @JoinColumn(name = "id")
    UserEntity userId;

}
