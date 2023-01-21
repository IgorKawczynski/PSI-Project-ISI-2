package com.psi.project.item;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.psi.project.core.CoreEntity;
import com.psi.project.item.valueobjects.*;
import com.psi.project.trade.TradeEntity;
import com.psi.project.user.UserEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;
import java.io.Serializable;

/**
 *  Encja przedmiotów sprzedaży
 *  @author Igor Kawczynski
 */
@Table(name = "item")
@Getter
@Setter
@Entity
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ItemEntity extends CoreEntity implements Serializable {

    @Embedded
    ItemNameValidator itemName;
    @Embedded
    DescriptionValidator description;
    @Embedded
    PriceValidator price;
    @Enumerated(EnumType.STRING)
    CategoryValidator category;
    @Enumerated(EnumType.STRING)
    StatusValidator status;

    @ManyToOne(fetch = FetchType.LAZY)
    @LazyToOne(LazyToOneOption.NO_PROXY)
    @JoinColumn(name = "seller_id", nullable = true)
    @JsonBackReference
    UserEntity userId;

    @OneToOne
    @JoinColumn(name = "trade_id")
    TradeEntity tradeId;

    @Builder
    public ItemEntity(
            ItemNameValidator itemName,
            DescriptionValidator description,
            PriceValidator price,
            CategoryValidator category,
            StatusValidator status,
            UserEntity userId

    ) {
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.category = category;
        this.status = status;
        this.userId = userId;
    }
}
