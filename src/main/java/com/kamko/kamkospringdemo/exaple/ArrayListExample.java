package com.kamko.kamkospringdemo.exaple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        Integer[] numbersArray = {1, 2, 3};
//        List<Integer> numbersList = List.of(1, 2, 3); // значения в таком листе поменять нельзя
//        numbersList.set(1, 10); // будет ошибка UnsupportedOperationException
        List<Integer> numbersList = new ArrayList<>(List.of(9, 2, 3, 5));

        System.out.println(numbersArray[0]);
        System.out.println(numbersList.get(0));

        numbersArray[1] = 10;
        numbersList.set(1, 10);

        System.out.println(numbersArray.length);
        System.out.println(numbersList.size());

        System.out.println(Arrays.toString(numbersArray));
        System.out.println(numbersList);
    }
}
