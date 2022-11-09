package com.psi.project.items;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.psi.project.items.valueobjects.*;
import com.psi.project.trade.TradeEntity;
import com.psi.project.users.UserEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;

/**
 *  Encja przedmiotów sprzedaży
 *  @author Igor Kawczynski
 */
@Table(name = "items")
@Getter
@Setter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class ItemEntity{

    @Id
    Integer id;
    @Embedded
    ItemNameValidator itemName;
    @Embedded
    DescriptionValidator description;
    @Embedded
    PriceValidator price;
    @Embedded
    CategoryValidator category;

    @Embedded
    StatusValidator status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    @LazyToOne(LazyToOneOption.NO_PROXY)
    UserEntity userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trade_id", nullable = false)
    @JsonBackReference
    @LazyToOne(LazyToOneOption.NO_PROXY)
    TradeEntity tradeId;

    @Builder
    public ItemEntity(
            ItemNameValidator itemName,
            DescriptionValidator description,
            PriceValidator price,
            CategoryValidator category,
            StatusValidator status,
            UserEntity userId,
            TradeEntity tradeId

    ) {
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.category = category;
        this.status = status;
        this.userId = userId;
        this.tradeId = tradeId;
    }
}
