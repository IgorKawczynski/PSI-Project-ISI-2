package com.psi.project.address;

import com.psi.project.address.valueobjects.CityValidator;
import com.psi.project.address.valueobjects.StreetValidator;
import com.psi.project.address.valueobjects.ZipCodeValidator;
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
public class AddressEntity extends CoreEntity implements Serializable {

    @Embedded
    ZipCodeValidator zipCode;

    @Embedded
    CityValidator city;

    @Embedded
    StreetValidator street;

    @OneToOne
    @JoinColumn(name = "id")
    UserEntity userId;

    @Builder
    public AddressEntity(
            ZipCodeValidator zipCode,
            CityValidator city,
            StreetValidator street
    ) {
        this.zipCode = zipCode;
        this.city = city;
        this.street = street;
    }

}
