package com.psi.project.graphql.user;


import com.psi.project.graphql.address.AddressGRAPHQL;
import com.psi.project.graphql.item.ItemGRAPHQL;
import com.psi.project.graphql.trade.TradeGRAPHQL;
import com.psi.project.graphql.trade.TradeGRAPHQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserGRAPHQLController {


    @Autowired
    private UserGRAPHQLService userGRAPHQLService;

    /**
     Metody Korzystające tylko z modelu (nie połączone z bazą danych)
     */
    @QueryMapping
    public List<UserGRAPHQL> allUsers() {
        return UserGRAPHQL.getAllUsers();
    }
    @QueryMapping
    public UserGRAPHQL userById(@Argument Integer id)  {
         return UserGRAPHQL.getById(id);
    }

    @QueryMapping
    public UserGRAPHQL userByEmail(@Argument String email)  {
        return UserGRAPHQL.getByEmail(email);
    }

    @QueryMapping
    public UserGRAPHQL userByFirstName(@Argument String firstName)  {
        return UserGRAPHQL.getByFirstName(firstName);
    }

    @QueryMapping
    public UserGRAPHQL userByLastName(@Argument String lastName)  {
        return UserGRAPHQL.getByLastName(lastName);
    }

    @QueryMapping
    public UserGRAPHQL userByPesel(@Argument String pesel)  {
        return UserGRAPHQL.getByPesel(pesel);
    }

    /**
     Metody Korzystające z serwisu - połączone z bazą danych
     */
    @QueryMapping
    public List<UserGRAPHQL> getAllUsers() {
        return userGRAPHQLService.getAllUsers();
    }

    @QueryMapping
    public UserGRAPHQL getUserById(@Argument Integer id) {
        return userGRAPHQLService.getUserById(id);
    }

    @MutationMapping
    public UserGRAPHQL addUser(@Argument UserGRAPHQL user) {
        return userGRAPHQLService.addUser(user);
    }

    @MutationMapping
    public UserGRAPHQL updateUserById(@Argument Integer id, @Argument String email, @Argument String firstName, @Argument String lastName, @Argument String pesel) {
        return userGRAPHQLService.updateUserById(id, email, firstName, lastName, pesel);
    }

    @MutationMapping
    public Integer deleteUserById(@Argument Integer id) {
        return userGRAPHQLService.deleteUserById(id);
    }

    @SchemaMapping
    public AddressGRAPHQL address(UserGRAPHQL user)  {
         return AddressGRAPHQL.getById(user.getAddress());
    }
}
