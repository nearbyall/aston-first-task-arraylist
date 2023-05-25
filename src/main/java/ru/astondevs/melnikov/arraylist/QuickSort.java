package ru.astondevs.melnikov.arraylist;

import java.util.Comparator;

/**
 * The QuickSort class provides static methods to perform quicksort on a MyArrayList.
 *
 * @see MyArrayList
 */
public class QuickSort {

    /**
     * Sorts the elements of the MyArrayList using the natural ordering of the elements.
     * This method assumes that the elements in the list implement the Comparable interface.
     *
     * @param list the MyArrayList to be sorted
     * @param <T>  the type of elements in the list, must implement Comparable
     */
    public static <T extends Comparable<T>> void sort(MyArrayList<T> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        quickSort(list, 0, list.size() - 1);
    }

    /**
     * Sorts the elements of the MyArrayList using the specified comparator.
     *
     * @param list       the MyArrayList to be sorted
     * @param comparator the comparator to determine the order of the elements
     * @param <T>        the type of elements in the list
     */
    public static <T> void sort(MyArrayList<T> list, Comparator<? super T> comparator) {
        if (list == null || list.isEmpty()) {
            return;
        }
        quickSort(list, 0, list.size() - 1, comparator);
    }

    private static <T extends Comparable<T>> void quickSort(MyArrayList<T> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quickSort(list, low, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, high);
        }
    }

    private static <T> void quickSort(MyArrayList<T> list, int low, int high, Comparator<? super T> comparator) {
        if (low < high) {
            int pivotIndex = partition(list, low, high, comparator);
            quickSort(list, low, pivotIndex - 1, comparator);
            quickSort(list, pivotIndex + 1, high, comparator);
        }
    }

    private static <T extends Comparable<T>> int partition(MyArrayList<T> list, int low, int high) {
        T pivot = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j).compareTo(pivot) <= 0) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }

    private static <T> int partition(MyArrayList<T> list, int low, int high, Comparator<? super T> comparator) {
        T pivot = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.compare(list.get(j), pivot) <= 0) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }

    private static <T> void swap(MyArrayList<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

}