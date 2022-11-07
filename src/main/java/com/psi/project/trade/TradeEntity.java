package com.psi.project.trade;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trade")
@Getter
@Setter
@RequiredArgsConstructor
public class TradeEntity {

    @Id
    Integer id;

}
