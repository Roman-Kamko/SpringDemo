package com.kamko.kamkospringdemo.exaple;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sets {
    public static void main(String[] args) {
        Set<Integer> numbersSet = new HashSet<>(List.of(1, 2, 40, 12));
        numbersSet.add(256);
        System.out.println(numbersSet.size());
        System.out.println(numbersSet);
    }
}
