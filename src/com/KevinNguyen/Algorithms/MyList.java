package com.KevinNguyen.Algorithms;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static int DefaultCapacity = 10;
    private Object elements [];

    //default contructor that sets my array
    public MyList() {
        elements = new Object[DefaultCapacity];
    }

    public void add(E e) {
        //checks to see if the list needs to be resized
        if(size == elements.length) {
            //resizes the list if the list is too small
            reSize();
        }
        //stores the element in the list
        elements[size++] = e;
    }

    public Object remove(int position) {
        // stores the removed object
        Object removedItem = elements[position];
        if (isEmpty()) {return null;} //checks to see if the array list is empty
        // shifts the elements in the list down one
        for (int i = position; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        //reduces the size of list by 1
        size--;
        return removedItem;
    }

    private boolean isEmpty(){
        return (size == 0);
    }



    private void reSize() {
        //doubles the size of the list
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    @SuppressWarnings("unchecked")
    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }


}
