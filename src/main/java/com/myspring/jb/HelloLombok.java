package com.myspring.jb;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        System.out.println("helloLombok = " + helloLombok);

        helloLombok.setName("lb");
        String name = helloLombok.getName();
        System.out.println("name = " + name);
    }
}
