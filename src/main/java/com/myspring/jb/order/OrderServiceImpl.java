package com.myspring.jb.order;

import com.myspring.jb.discount.DiscountPolicy;
import com.myspring.jb.discount.FixDiscountPolicy;
import com.myspring.jb.discount.RateDiscountPolicy;
import com.myspring.jb.member.Member;
import com.myspring.jb.member.MemberRepository;
import com.myspring.jb.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {
    // 3. [필드 주입] - 수정, 테스트가 불편하여 권장X
//    @Autowired private MemberRepository memberRepository;
//    @Autowired private DiscountPolicy discountPolicy;

    // 2. [수정자 (setter) 주입] - 선택, 변경 가능성
//    private MemberRepository memberRepository;
//    private DiscountPolicy discountPolicy;

//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        System.out.println("memberRepository2 = " + memberRepository);
//        this.memberRepository = memberRepository;
//    }
//    @Autowired (required = false)   // 주입할 대상이 없어도 동작하게 하는 옵션
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        System.out.println("discountPolicy2 = " + discountPolicy);
//        this.discountPolicy = discountPolicy;
//    }

    // 1. [생성자 주입] - 불변, 필수
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

//    @Autowired    // -> 생성자가 1개만 있을 때는 생략 가능 (생략해도 자동 주입 됨)
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        System.out.println("memberRepository1 = " + memberRepository);
        System.out.println("discountPolicy1 = " + discountPolicy);
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // 4. [일반 메서드 주입]
//    @Autowired
//    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
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
