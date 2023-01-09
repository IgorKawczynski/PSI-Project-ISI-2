package com.psi.project.trade;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepository extends JpaRepository<TradeEntity, Long> {

    TradeEntity findTradeEntityById(Long id);

}
