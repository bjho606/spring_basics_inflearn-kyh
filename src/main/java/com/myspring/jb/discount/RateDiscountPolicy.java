package com.myspring.jb.discount;

import com.myspring.jb.annotation.MainDiscountPolicy;
import com.myspring.jb.member.Grade;
import com.myspring.jb.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("mainDiscountPolicy")    // 2. @Qualifier 사용
//@Primary    // 3. @Primary 사용
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {
    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
