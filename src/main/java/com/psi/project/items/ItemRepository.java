package com.psi.project.items;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * Repozytorium JPA przedmiotów sprzedaży
 *
 */
@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

    ItemEntity findItemEntityById(Long id);
}
