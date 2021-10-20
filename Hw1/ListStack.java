/************************************

 Author:         Daniel Stanev
 Course:         CS 3345.004
 Date:           23 Sep 2021
 Assignment:     Homework #01
 Version:        Java SE 11 (LTS)

 Description: Linked list implementation
 of a stack.

 *************************************/

public class ListStack implements BKStack {
    // Data Fields
    int size = 0;
    Node head;

    private class Node {
        // Data Fields
        double value;
        Node next;

        // Constructors
        private Node() {}
        private Node(double value) { this.value = value; }

        // Accessors/Mutators
        private void setNext(Node next) { this.next = next; }
        private double getValue() { return value; }
        private Node getNext() { return next; }
    }

    // Constructor
    public ListStack() { head = new Node(); }

    // Checks if the stack is empty
    @Override
    public boolean isEmpty() { return (size == 0); }

    // Returns the value of the top element without removing
    @Override
    public double peek() { return head.getValue(); }

    // Pushes an element on top of the stack
    @Override
    public void push(double d) {
        if (size == 0)
            head = new Node(d);
        else {
            Node temp = new Node(d);
            temp.setNext(head);
            head = temp;
        }
        size++;
    }

    // Removes an element from the top of the stack
    @Override
    public double pop() {
        if (size != 0) {
            double val = head.getValue();
            head = head.getNext();
            size--;
            return val;
        }
        return 0;
    }        
}
