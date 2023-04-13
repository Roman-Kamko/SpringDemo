package com.kamko.kamkospringdemo.exaple;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.HashMap;
import java.util.Map;

public class Maps {


    public static void main(String[] args) {
//        Map<String, Integer> numbersMap = new HashMap<>(Map.of("four", 4, "five", 5));
//        numbersMap.put("one", 1);
//        numbersMap.put("two", 2);
//        numbersMap.put("three", 3);
//        System.out.println(numbersMap);
//        System.out.println(numbersMap.get("two"));
//        System.out.println(numbersMap.size());

        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("Ivan", "89110000001");
        phoneBook.put("Dmitriy", "89110000002");
        System.out.println(phoneBook);
        phoneBook.put("Ivan", "89110000003");
        System.out.println(phoneBook);
        System.out.println(phoneBook.get("Ivan"));
        phoneBook.remove("Dmitriy");
        System.out.println(phoneBook);
        System.out.println(phoneBook.get("Dmitriy")); // null

        if (phoneBook.containsKey("Dmitriy")) {
            System.out.println(phoneBook.get("Dmitriy"));
        } else {
            System.out.println("контакт не найден");
        }

        for (Map.Entry<String, String> contact : phoneBook.entrySet()) {
            System.out.println("контакт " + contact.getKey() + ": " + contact.getValue());
        }

        for (String name : phoneBook.keySet()) {
            System.out.println("в мапе присутствует контакт по имени: "+ name);
        }

        for (String phoneNum : phoneBook.values()) {
            System.out.println("в мапе присутствует номер телефона: " + phoneNum);
        }

        System.out.println(phoneBook.getOrDefault("Kirill", "00000000"));
        // вернет дефолтное значение если ключа не окажется в мапе

        phoneBook.remove("Ivan", "000000000000");
        // удалит только если и ключ и значение совпадут с имеющимися в мапе
        System.out.println(phoneBook);


    }
}

