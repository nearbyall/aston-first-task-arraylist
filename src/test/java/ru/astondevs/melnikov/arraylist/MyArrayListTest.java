package ru.astondevs.melnikov.arraylist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

class MyArrayListTest {

    private MyArrayList<Integer> myList;

    @BeforeEach
    void setUp() {
        myList = new MyArrayList<>();
    }

    @Test
    void testAddAndGet() {
        myList.add(1);
        myList.add(2);
        myList.add(3);

        Assertions.assertEquals(1, myList.get(0));
        Assertions.assertEquals(2, myList.get(1));
        Assertions.assertEquals(3, myList.get(2));
    }

    @Test
    void testRemove() {
        myList.add(1);
        myList.add(2);
        myList.add(3);

        myList.remove(1);

        Assertions.assertEquals(1, myList.get(0));
        Assertions.assertEquals(3, myList.get(1));
        Assertions.assertEquals(2, myList.size());
    }

    @Test
    void testClear() {
        myList.add(1);
        myList.add(2);
        myList.add(3);

        myList.clear();

        Assertions.assertEquals(0, myList.size());
        Assertions.assertTrue(myList.isEmpty());
    }

    @Test
    void testSort() {
        myList.add(3);
        myList.add(1);
        myList.add(2);

        Comparator<Integer> comparator = Comparator.naturalOrder();
        myList.sort(comparator);

        Assertions.assertEquals(1, myList.get(0));
        Assertions.assertEquals(2, myList.get(1));
        Assertions.assertEquals(3, myList.get(2));
    }

    @Test
    void testIsEmpty() {
        Assertions.assertTrue(myList.isEmpty());

        myList.add(1);

        Assertions.assertFalse(myList.isEmpty());
    }

    @Test
    void testSize() {
        Assertions.assertEquals(0, myList.size());

        myList.add(1);
        myList.add(2);
        myList.add(3);

        Assertions.assertEquals(3, myList.size());
    }

    @Test
    void testSet() {
        myList.add(1);
        myList.add(2);
        myList.add(3);

        myList.set(1, 4);

        Assertions.assertEquals(1, myList.get(0));
        Assertions.assertEquals(4, myList.get(1));
        Assertions.assertEquals(3, myList.get(2));
    }

}