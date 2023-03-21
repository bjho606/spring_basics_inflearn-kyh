package com.myspring.jb.singleton;

public class StatefulService {
//    // [문제가 있는 방식]
//    private int price;  // 상태를 유지하는 필드
//    public void order(String name, int price) {
//        System.out.println("name = " + name + " price = " + price);
//        this.price = price; // 여기가 문제!
//    }
//
//    public int getPrice() {
//        return price;
//    }

    // [stateless 로 처리한 방식]
    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        return price;
    }
}
