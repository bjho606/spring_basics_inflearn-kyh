package com.myspring.jb.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

//        // [문제가 있는 방식]
//        // ThreadA : 사용자 A 10000원 주문
//        statefulService1.order("userA", 10000);
//        // ThreadB : 사용자 B 20000원 주문
//        statefulService2.order("userB", 20000);
//
//        // ThreadA : 사용자 A 주문 금액 조회
//        int price = statefulService1.getPrice();
//        System.out.println("price = " + price);
//
//        assertThat(statefulService1.getPrice()).isEqualTo(20000);

        // [stateless 로 처리한 방식]
        // ThreadA : 사용자 A 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);
        // ThreadB : 사용자 B 20000원 주문
        int userBPrice = statefulService2.order("userB", 20000);

        // ThreadA : 사용자 A 주문 금액 조회
        System.out.println("price = " + userAPrice);

    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}