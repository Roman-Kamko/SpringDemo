package com.kamko.kamkospringdemo.exaple;

import java.util.HashMap;
import java.util.Map;

public class Maps {


    public static void main(String[] args) {
        Map<String, Integer> numbersMap = new HashMap<>(Map.of("four", 4, "five", 5));
        numbersMap.put("one", 1);
        numbersMap.put("two", 2);
        numbersMap.put("three", 3);
        System.out.println(numbersMap);
        System.out.println(numbersMap.get("two"));
        System.out.println(numbersMap.size());
    }
}

