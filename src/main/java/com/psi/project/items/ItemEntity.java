package com.psi.project.items;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.psi.project.items.valueobjects.CategoryValidator;
import com.psi.project.items.valueobjects.DescriptionValidator;
import com.psi.project.items.valueobjects.PriceValidator;
import com.psi.project.items.valueobjects.StatusValidator;
import com.psi.project.trade.TradeEntity;
import com.psi.project.users.UserEntity;
import com.psi.project.users.valueobjects.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import javax.persistence.*;

/**
 *
 * Encja przedmiotów sprzedaży
 *
 */
@Table(name = "items")
@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class ItemEntity{

    @Id
    private Integer id;
    @Embedded
    NameValidator name;
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
    private UserEntity userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trade_id", nullable = false)
    @JsonBackReference
    @LazyToOne(LazyToOneOption.NO_PROXY)
    private TradeEntity tradeId;

    @Builder
    public ItemEntity(
            NameValidator name,
            DescriptionValidator description,
            PriceValidator price,
            CategoryValidator category,
            StatusValidator status,
            UserEntity userId,
            TradeEntity tradeId

    ) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.status = status;
        this.userId = userId;
        this.tradeId = tradeId;
    }
}
