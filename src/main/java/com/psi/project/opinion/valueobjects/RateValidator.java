package com.psi.project.opinion.valueobjects;

import com.psi.project.core.interfaces.CoreValidator;
import com.psi.project.opinion.exceptions.IllegalRateException;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Embeddable
@NotNull
@NoArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RateValidator implements CoreValidator {

    @Column
    Integer rate;

    public RateValidator(Integer rate) {
        if(Objects.isNull(rate) )
            throw new IllegalRateException("Rate is necessary!");
        if( rate < 0)
            throw new IllegalRateException("Rate can not be less than 0!");
        if( rate > 5)
            throw new IllegalRateException("Rate can not be greater than 5!");
        this.rate = rate;
    }

    public Integer toInteger() {
        return this.rate;
    }

    @Override
    public String toString() {
        return rate.toString();
    }
}
