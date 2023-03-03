package com.myspring.jb;

import com.myspring.jb.member.Grade;
import com.myspring.jb.member.Member;
import com.myspring.jb.member.MemberService;
import com.myspring.jb.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = "  + findMember.getName());
    }
}
