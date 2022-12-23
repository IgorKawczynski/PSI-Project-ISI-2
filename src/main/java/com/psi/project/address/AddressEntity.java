package com.psi.project.address;

import com.psi.project.core.CoreEntity;
import com.psi.project.user.UserEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.io.Serializable;


@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
public class AddressEntity extends CoreEntity implements Serializable {

    String zipCode;
    String city;
    String street;

    @OneToOne
    @JoinColumn(name = "id")
    UserEntity userId;

}
