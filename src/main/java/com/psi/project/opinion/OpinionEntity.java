package com.psi.project.opinion;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.psi.project.core.CoreEntity;
import com.psi.project.opinion.valueobjects.DescriptionValidator;
import com.psi.project.opinion.valueobjects.RateValidator;
import com.psi.project.trade.TradeEntity;
import com.psi.project.user.UserEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "opinion")
@Getter
@Setter
@Entity
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OpinionEntity extends CoreEntity implements Serializable {

    @Embedded
    RateValidator rate;

    @Embedded
    DescriptionValidator description;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trade_id")
    TradeEntity tradeEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    UserEntity userId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "buyer_id")
    UserEntity buyerId;

    @Builder
    public OpinionEntity(
            RateValidator rate,
            DescriptionValidator description,
            TradeEntity tradeEntity,
            UserEntity userId,
            UserEntity buyerId
    ) {
        this.rate = rate;
        this.description = description;
        this.tradeEntity = tradeEntity;
        this.userId = userId;
        this.buyerId = buyerId;
    }
}
