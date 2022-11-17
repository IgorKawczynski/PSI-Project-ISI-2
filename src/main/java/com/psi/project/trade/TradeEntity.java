package com.psi.project.trade;

import com.psi.project.basic.BasicEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "trade")
@Getter
@Setter
@NoArgsConstructor
public class TradeEntity extends BasicEntity {


}
