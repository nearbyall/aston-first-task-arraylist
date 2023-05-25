package ru.astondevs.melnikov.arraylist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class QuickSortTest {

    private MyArrayList<Integer> numbers;
    private MyArrayList<String> words;

    @BeforeEach
    void setUp() {
        numbers = new MyArrayList<>();
        words = new MyArrayList<>();
    }

    @Test
    void testQuickSortWithoutComparator() {
        numbers.add(5);
        numbers.add(2);
        numbers.add(9);
        numbers.add(1);

        QuickSort.sort(numbers);

        Assertions.assertEquals(1, numbers.get(0));
        Assertions.assertEquals(2, numbers.get(1));
        Assertions.assertEquals(5, numbers.get(2));
        Assertions.assertEquals(9, numbers.get(3));
    }

    @Test
    void testQuickSortWithComparator() {
        words.add("apple");
        words.add("cat");
        words.add("banana");
        words.add("surprise");
        words.add("chia");

        Comparator<String> lengthComparator = Comparator.comparing(String::length);
        QuickSort.sort(words, lengthComparator);

        Assertions.assertEquals("cat", words.get(0));
        Assertions.assertEquals("chia", words.get(1));
        Assertions.assertEquals("apple", words.get(2));
        Assertions.assertEquals("banana", words.get(3));
        Assertions.assertEquals("surprise", words.get(4));
    }

}