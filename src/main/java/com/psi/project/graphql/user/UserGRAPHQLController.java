package com.psi.project.graphql.user;


import com.psi.project.graphql.address.AddressGRAPHQL;
import com.psi.project.graphql.item.ItemGRAPHQL;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserGRAPHQLController {

    @QueryMapping
    public UserGRAPHQL userById(@Argument Integer id)  {
         return UserGRAPHQL.getById(id);
    }

    @QueryMapping
    public List<UserGRAPHQL> allUsers() {
        return UserGRAPHQL.getAllUsers();
    }

    @MutationMapping
    public UserGRAPHQL updateUserById(@Argument Integer id, @Argument String email, @Argument String firstName, @Argument String lastName, @Argument String pesel) {
        return UserGRAPHQL.updateById(id, email, firstName, lastName, pesel);
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

    @SchemaMapping
    public AddressGRAPHQL address(UserGRAPHQL user)  {
         return AddressGRAPHQL.getById(user.getAddress());
    }
}
