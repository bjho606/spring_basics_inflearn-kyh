package com.myspring.jb;

import com.myspring.jb.member.Grade;
import com.myspring.jb.member.Member;
import com.myspring.jb.member.MemberService;
import com.myspring.jb.member.MemberServiceImpl;
import com.myspring.jb.order.Order;
import com.myspring.jb.order.OrderService;
import com.myspring.jb.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
