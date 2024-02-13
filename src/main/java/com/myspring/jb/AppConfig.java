package com.myspring.jb;

import com.myspring.jb.discount.DiscountPolicy;
import com.myspring.jb.discount.FixDiscountPolicy;
import com.myspring.jb.discount.RateDiscountPolicy;
import com.myspring.jb.member.MemberRepository;
import com.myspring.jb.member.MemberService;
import com.myspring.jb.member.MemberServiceImpl;
import com.myspring.jb.member.MemoryMemberRepository;
import com.myspring.jb.order.OrderService;
import com.myspring.jb.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // Spring 설정
//@Configuration  // 이걸 주석처리 후, configuration test 실행시,
public class AppConfig {
    @Bean   // Spring Container 에 등록
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
//        return new OrderServiceImpl(memberRepository(), discountPolicy());
        return null;
    }

    // 원래 자바 코드 흐름상, memberRepository 는 3번 호출이 되어야 한다.
    // but -> spring이 싱글톤을 보장해주기 때문에 한번만 호출된다.
    // 만약 @Configuration 을 주석처리하면, 싱글톤이 보장되지 않기 때문에, 3번 호출된다.
}
