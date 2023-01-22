package com.psi.project.graphql.item;

import com.psi.project.graphql.address.AddressGRAPHQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemGRAPHQLRepository extends JpaRepository<ItemGRAPHQL, Integer> {

    ItemGRAPHQL findItemGRAPHQLById(Integer id);
}
