package com.psi.project.graphql.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGRAPHQLRepository extends JpaRepository<UserGRAPHQL, Integer> {
}
