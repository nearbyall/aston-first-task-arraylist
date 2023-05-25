package ru.astondevs.melnikov.arraylist;

import java.util.Arrays;
import java.util.Comparator;

/**
 * The MyArrayList class represents a generic implementation of a dynamic array.
 * It allows adding, accessing, modifying, and removing elements similar to a regular array,
 * but with the ability to automatically resize itself when necessary.
 *
 * @param <E> the type of elements stored in the list
 */
public class MyArrayList<E> {

    /**
     * The default capacity of the list.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * The factor by which the list grows when it needs to be resized.
     */
    private static final int GROWTH_FACTOR = 2;

    /**
     * The array that holds the elements of the list.
     */
    private Object[] elements;

    /**
     * The number of elements currently stored in the list.
     */
    private int size;

    /**
     * Constructs an empty MyArrayList with the default initial capacity.
     */
    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Adds the specified element to the end of the list.
     *
     * @param element the element to be added
     */
    public void add(E element) {
        if (size == elements.length) {
            increaseCapacity();
        }
        elements[size++] = element;
    }

    /**
     * Returns the element at the specified index in the list.
     *
     * @param index the index of the element to be retrieved
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        return (E) elements[index];
    }

    /**
     * Replaces the element at the specified index in the list with the specified element.
     *
     * @param index   the index of the element to be replaced
     * @param element the new element to be stored at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    public void set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        elements[index] = element;
    }

    /**
     * Removes the element at the specified index from the list.
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     *
     * @param index the index of the element to be removed
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
    }

    /**
     * Checks whether the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list
     */
    public int size() {
        return size;
    }

    /**
     * Removes all elements from the list.
     */
    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    /**
     * Sorts the elements of the list using the specified comparator.
     *
     * @param comparator the comparator to determine the order of the elements
     */
    public void sort(Comparator<? super E> comparator) {
        Arrays.sort((E[]) elements, 0, size, comparator);
    }

    /**
     * Increases the capacity of the list by allocating a new array with a larger size
     * and copying the elements from the old array to the new array.
     */
    private void increaseCapacity() {
        int newCapacity = elements.length * GROWTH_FACTOR;
        elements = Arrays.copyOf(elements, newCapacity);
    }

}