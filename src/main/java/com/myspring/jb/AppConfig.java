package com.myspring.jb;

import com.myspring.jb.discount.FixDiscountPolicy;
import com.myspring.jb.member.MemberService;
import com.myspring.jb.member.MemberServiceImpl;
import com.myspring.jb.member.MemoryMemberRepository;
import com.myspring.jb.order.OrderService;
import com.myspring.jb.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
