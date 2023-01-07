package com.psi.project.item;

import org.springframework.data.jpa.repository.JpaRepository;
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

}
