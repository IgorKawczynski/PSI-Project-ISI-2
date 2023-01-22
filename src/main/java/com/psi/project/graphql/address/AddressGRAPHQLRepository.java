package com.psi.project.graphql.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface AddressGRAPHQLRepository extends JpaRepository<AddressGRAPHQL, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE address_graphql SET city = ?1 WHERE id = ?2 ", nativeQuery = true)
    int updateAddress(String city, Integer id);

    AddressGRAPHQL findAddressGRAPHQLById(Integer id);
}
