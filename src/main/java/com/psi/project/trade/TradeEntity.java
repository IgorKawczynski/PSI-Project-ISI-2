package com.psi.project.trade;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.psi.project.core.CoreEntity;
import com.psi.project.item.ItemEntity;
import com.psi.project.opinion.OpinionEntity;
import com.psi.project.trade.valueobjects.ValueValidator;
import com.psi.project.user.UserEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "trade")
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TradeEntity extends CoreEntity implements Serializable {

    @Embedded
    ValueValidator value;

    @ManyToOne(fetch = FetchType.LAZY)
    @LazyToOne(LazyToOneOption.NO_PROXY)
    @JoinColumn(name = "buyer_id", nullable = true)
    @JsonBackReference
    UserEntity userId;

    @OneToOne(mappedBy = "tradeId", fetch = FetchType.EAGER)
    @JsonBackReference
    ItemEntity itemEntity;

    @OneToOne
    @JoinColumn(name = "id")
    OpinionEntity opinionId;

    @Builder
    public TradeEntity(
            ValueValidator value,
            UserEntity userId,
            ItemEntity itemEntity
    ) {
        this.value = value;
        this.userId = userId;
        this.itemEntity = itemEntity;
    }


}
