package com.psi.project.graphql.user;


import java.util.Arrays;
import java.util.List;

public class UserGRAPHQL {

    private final String id;
    private final String email;
    private final String firstName;
    private final String lastName;
    private final String pesel;
    private final String addressId;

    public UserGRAPHQL(String id, String email, String firstName, String lastName, String pesel, String addressId) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.addressId = addressId;
    }

    private static final List<UserGRAPHQL> users = Arrays.asList(
            new UserGRAPHQL("1 User",
                    "emailPierwszy@op.pl",
                    "Ignacy",
                    "Dobromir",
                    "01382500669",
                    "2 Address"),
            new UserGRAPHQL("2 User",
                    "emailDrugi@op.pl",
                    "Arkadia",
                    "Fajna",
                    "02482564669",
                    "1 Address"),
            new UserGRAPHQL("3 User",
                    "emailTrzeci@op.pl",
                    "Konrad",
                    "Wierzba",
                    "05812500767",
                    "5 Address"),
            new UserGRAPHQL("4 User",
                    "emailCzwarty@op.pl",
                    "Krystyna",
                    "Ronualdzka",
                    "02482504669",
                    "4 Address"),
            new UserGRAPHQL("5 User",
                    "emailPiaty@op.pl",
                    "Leonard",
                    "Meszyński",
                    "06613504551",
                    "3 Address")
    );

    public static UserGRAPHQL getById(String id) {
        return users
                .stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
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

    public static UserGRAPHQL getByAddress(String addressId) {
        return users
                .stream()
                .filter(user -> user.getAddress().equals(addressId))
                .findFirst()
                .orElse(null);
    }

    public String getId() {
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

    public String getAddress() {
        return addressId;
    }

}
