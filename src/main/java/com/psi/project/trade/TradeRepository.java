package com.psi.project.trade;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface TradeRepository extends JpaRepository<TradeEntity, Long> {

    TradeEntity findTradeEntityById(Long id);

    @Query(value = "SELECT * FROM trade WHERE trade.buyer_id=:id", nativeQuery = true)
    Page<TradeEntity> findAllByBuyerId(Long id, Pageable pageable);

}
