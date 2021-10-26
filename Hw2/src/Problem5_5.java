/************************************
 
 Author:         Daniel Stanev
 Course:         CS 3345.004
 Date:           25 Oct 2021
 Assignment:     Homework #02
 Version:        Java SE 11 (LTS)
 
 Description: Exercise 5.5

 These are very bare bones implementations
 of the class just to show that they work.
 
 *************************************/

public class Problem5_5 {
    public static class linkedList {
        // linked list data fields
        public Node root;
        public int size;

        // Node class
        class Node {
            public int data;
            public Node next;

            Node(int data) { this.data = data; }
        }

        // Constructor
        public linkedList() { 
            root = null;
            size = 0;
        }

        // insert method
        public void insert(int data) {
            if (root == null)
                root = new Node(data);

            Node current = root;
            while (current.next != null)
                current = current.next;
            
            current.next = new Node(data);
            size++;
        }
    }

    // This is an ultra bare bones hash table just to prove the 
    // single chaining works
    public static class HashTable {
        public static final int TABLESIZE = 10;
        public linkedList data[];

        // Constructor
        public HashTable() { 
            data = new linkedList[TABLESIZE]; 
            for (int i = 0; i < TABLESIZE; i++)
                data[i] = new linkedList();
        }

        // Insert method
        public void insert(int info) {
            int key = info % TABLESIZE;
            data[key].insert(info);
        }

    }
    public static void main(String[] x) {
        int num;
        java.util.Scanner input = new java.util.Scanner(System.in);
        HashTable table = new HashTable();

        System.out.print("Enter positive integers to hash or a negative to stop: ");

        // Populates the hash table
        do {
            num = input.nextInt();
            if (num >= 0)
                table.insert(num);
        } while (num > -1);

        // Shows how big the chain at each key is
        for (int i = 0; i < 10; i++) 
            System.out.printf("Values stored at key = %d: %d\n", i, table.data[i].size);
    }
}
