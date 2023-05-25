package ru.astondevs.melnikov.arraylist;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        MyArrayList<Integer> numbers = new MyArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(9);
        numbers.add(1);
        numbers.add(3);
        QuickSort.sort(numbers);
        System.out.println("Отсортированный список: ");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

        MyArrayList<String> words = new MyArrayList<>();
        words.add("apple");
        words.add("orange");
        words.add("banana");
        words.add("grape");
        words.add("cherry");

        Comparator<String> lengthComparator = Comparator.comparing(String::length);
        QuickSort.sort(words, lengthComparator);
        System.out.println("Отсортированный список: ");
        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i));
        }
    }

}