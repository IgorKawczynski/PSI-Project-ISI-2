package com.psi.project.item;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 *  Repozytorium JPA przedmiotów sprzedaży
 *  @author Igor Kawczyński
 *
 */
@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

    ItemEntity findItemEntityById(Long id);

//    Page<ItemEntity> findAllByItemNameStartingWith(String name, Pageable pageable);

    @Query(value = "SELECT * FROM item WHERE item_name LIKE :name", nativeQuery = true)
    Page<ItemEntity> findAllByItemNameBeginningWith(@Param("name") String name, Pageable pageable);

}
