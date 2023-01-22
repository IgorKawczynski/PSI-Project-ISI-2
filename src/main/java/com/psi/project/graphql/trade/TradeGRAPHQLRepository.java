package com.psi.project.graphql.trade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeGRAPHQLRepository extends JpaRepository<TradeGRAPHQL, Integer> {

    TradeGRAPHQL findTradeGRAPHQLById(Integer id);
}
