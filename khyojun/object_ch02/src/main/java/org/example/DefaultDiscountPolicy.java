package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DefaultDiscountPolicy implements DiscountPolicy{

    private List<DiscountCondition> conditions = new ArrayList<>();

    public DefaultDiscountPolicy(List<DiscountCondition> conditions) {
        this.conditions = conditions;
    }

    public Money calculateDiscountAmount(Screening screening){
        for(DiscountCondition each:conditions){
            if(each.isSatisfiedBy(screening)){
                return getDiscountAmount(screening);
            }
        }
        return Money.ZERO;
    }


    abstract protected Money getDiscountAmount(Screening screening);
}
