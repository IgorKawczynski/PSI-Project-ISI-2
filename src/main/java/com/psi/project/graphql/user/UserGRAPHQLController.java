package com.psi.project.graphql.user;


import com.psi.project.graphql.address.AddressGRAPHQL;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class UserGRAPHQLController {

    @QueryMapping
    public UserGRAPHQL userById(@Argument String id)  {
         return UserGRAPHQL.getById(id);
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
