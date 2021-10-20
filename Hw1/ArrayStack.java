/************************************
 
 Author:         Daniel Stanev
 Course:         CS 3345.004
 Date:           23 Sep 2021
 Assignment:     Homework #01
 Version:        Java SE 11 (LTS)
 
 Description: Array implementation of
 a stack.
 
 *************************************/

public class ArrayStack implements BKStack {
    // Data Fields
    public static final int INITIAL_CAPACITY = 32;
    public static final int SCALE_FACTOR = 2;
    private double[] data;
    private int size = 0;

    // Constructor
    ArrayStack() { data = new double[INITIAL_CAPACITY]; }

    // Resizes the data array.
    private void resize(int newSize) {
        double[] newData = new double[newSize];
        for (int i = 0; i < size; i++)
            newData[i] = data[i];
        data = newData;
    }
    
    // Checks if the stack is empty
    @Override
    public boolean isEmpty() { return size == 0; }

    // Returns the value of the top element without removing
    @Override
    public double peek()     { return data[size - 1]; }

    // Adds a value to the top of the stack
    @Override
    public void push(double d) {
        if (size == data.length)
            resize(size * SCALE_FACTOR);
        data[size++] = d;
    }

    // Removes a value from the top of the stack
    @Override
    public double pop() {
        if (data.length >= SCALE_FACTOR * SCALE_FACTOR * size)
            resize(data.length / SCALE_FACTOR);
        return data[--size];
    }
}
