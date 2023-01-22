package com.psi.project.graphql.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemGRAPHQLRepository extends JpaRepository<ItemGRAPHQL, Integer> {
}
