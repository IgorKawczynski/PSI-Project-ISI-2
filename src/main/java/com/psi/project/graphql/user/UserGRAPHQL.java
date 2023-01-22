package com.psi.project.graphql.user;


import com.psi.project.graphql.item.ItemGRAPHQL;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "USERS_GRAPHQL")
public class UserGRAPHQL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private String pesel;
    private Integer addressId;

    public UserGRAPHQL(Integer id, String email, String firstName, String lastName, String pesel, Integer addressId) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.addressId = addressId;
    }

    private static final List<UserGRAPHQL> users = Arrays.asList(
            new UserGRAPHQL(1,
                    "emailPierwszy@op.pl",
                    "Ignacy",
                    "Dobromir",
                    "01382500669",
                    2),
            new UserGRAPHQL(2,
                    "emailDrugi@op.pl",
                    "Arkadia",
                    "Fajna",
                    "02482564669",
                    1),
            new UserGRAPHQL(3,
                    "emailTrzeci@op.pl",
                    "Konrad",
                    "Wierzba",
                    "05812500767",
                    5),
            new UserGRAPHQL(4,
                    "emailCzwarty@op.pl",
                    "Krystyna",
                    "Ronualdzka",
                    "02482504669",
                    4),
            new UserGRAPHQL(5,
                    "emailPiaty@op.pl",
                    "Leonard",
                    "Meszyński",
                    "06613504551",
                    3)
    );

    public static UserGRAPHQL getById(Integer id) {
        return users
                .stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static List<UserGRAPHQL> getAllUsers() {
        return users;
    }

    public static UserGRAPHQL updateById(Integer id, String email, String firstName, String lastName, String pesel) {
        var user = users
                .stream()
                .filter(userX -> userX.getId().equals(id))
                .findFirst()
                .orElse(null);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPesel(pesel);
        return user;
    }

    public static UserGRAPHQL getByEmail(String email) {
        return users
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public static UserGRAPHQL getByFirstName(String firstName) {
        return users
                .stream()
                .filter(user -> user.getFirstName().equals(firstName))
                .findFirst()
                .orElse(null);
    }

    public static UserGRAPHQL getByLastName(String lastName) {
        return users
                .stream()
                .filter(user -> user.getLastName().equals(lastName))
                .findFirst()
                .orElse(null);
    }

    public static UserGRAPHQL getByPesel(String pesel) {
        return users
                .stream()
                .filter(user -> user.getPesel().equals(pesel))
                .findFirst()
                .orElse(null);
    }

    public static UserGRAPHQL getByAddress(Integer addressId) {
        return users
                .stream()
                .filter(user -> user.getAddress().equals(addressId))
                .findFirst()
                .orElse(null);
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public Integer getAddress() {
        return addressId;
    }

}
