package com.myspring.jb.order;

import com.myspring.jb.discount.DiscountPolicy;
import com.myspring.jb.discount.FixDiscountPolicy;
import com.myspring.jb.discount.RateDiscountPolicy;
import com.myspring.jb.member.Member;
import com.myspring.jb.member.MemberRepository;
import com.myspring.jb.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor    // final이 붙은 멤버들로 생성자를 자동으로 만들어주는 lombok 기능
public class OrderServiceImpl implements OrderService {
    // 웬만하면 생성자 주입 방식 쓰자~
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

////    @Autowired    // -> 생성자가 1개만 있을 때는 생략 가능 (생략해도 자동 주입 됨)
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        System.out.println("memberRepository1 = " + memberRepository);
//        System.out.println("discountPolicy1 = " + discountPolicy);
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
