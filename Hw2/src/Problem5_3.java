/************************************
 
 Author:         Daniel Stanev
 Course:         CS 3345.004
 Date:           25 Oct 2021
 Assignment:     Homework #02
 Version:        Java SE 11 (LTS)
 
 Description: Exercise 5.3

 A small hash table implementation that
 shows I can count the number of collisions
 *************************************/

public class Problem5_3 {
    public static class HashTable {
        // data fields
        public static final int TABLESIZE = 100;
        public int linearCollisions;
        public int quadraticCollisions;
        public int doublehashCollisions;
        public int data[];

        // Constructor
        public HashTable() { 
            data = new int[TABLESIZE]; 
            linearCollisions = 0;
            quadraticCollisions = 0;
            doublehashCollisions = 0;
            for (int i = 0; i < TABLESIZE; i++)
                data[i] = 0;
        }

        // Insert methods
        // linear probing
        public void linear(int info) {
            int key = info % TABLESIZE;
            while (data[key] != 0) {
                linearCollisions++;
                key++;
            }
            data[key] = info;
        }

        // quadratic probing
        public void quadratic(int info) {
            int keyOne = info % TABLESIZE;
            int keyTwo = keyOne;
            int i = 1;
            while (data[keyTwo] != 0) {
                quadraticCollisions++;
                keyTwo = keyOne + (i * i);
                i++;
            }
            data[keyTwo] = info;
        }

        // double hashing
        public void doubleHash(int info) {
            int keyOne = info % TABLESIZE;
            int keyTwo = keyOne;
            int i = 1;
            while (data[keyTwo] != 0) {
                doublehashCollisions++;
                keyTwo = keyOne + (i * (17 - (keyOne % 17)));
                i++;
            }
            data[keyTwo] = info;
        }
    }
    public static void main(String[] x) {
        HashTable linearTable = new HashTable();
        HashTable quadTable = new HashTable();
        HashTable doubleTable = new HashTable();

        // Expected collisions refers to cumulative amount for that probe
        linearTable.linear(17);     // Expected Collisions: 0
        linearTable.linear(117);    // Expected Collisions: 1
        linearTable.linear(1117);   // Expected Collisions: 3
        linearTable.linear(1);      // Expected Collisions: 3
        linearTable.linear(1);      // Expected Collisions: 4
        linearTable.linear(16);     // Expected Collisions: 4
        linearTable.linear(16);     // Expected Collisions: 8
        linearTable.linear(20);     // Expected Collisions: 9
        linearTable.linear(20);     // Expected Collisions: 11

        quadTable.quadratic(1);     // Expected Collisions: 0
        quadTable.quadratic(1);     // Expected Collisions: 1
        quadTable.quadratic(1);     // Expected Collisions: 3
        quadTable.quadratic(5);     // Expected Collisions: 4
        quadTable.quadratic(104);   // Expected Collisions: 4
        quadTable.quadratic(4);     // Expected Collisions: 6
        quadTable.quadratic(27);    // Expected Collisions: 6

        doubleTable.doubleHash(1);  // Expected Collisions: 0
        doubleTable.doubleHash(17); // Expected Collisions: 0
        doubleTable.doubleHash(1);  // Expected Collisions: 2
        doubleTable.doubleHash(33); // Expected Collisions: 3
        doubleTable.doubleHash(16); // Expected Collisions: 3
        doubleTable.doubleHash(16); // Expected Collisions: 5
        doubleTable.doubleHash(54); // Expected Collisions: 5
        doubleTable.doubleHash(154);// Expected Collisions: 6

        // prints out number of each type of collision
        System.out.printf("Number of linear probe collisions:     %d\n", linearTable.linearCollisions);
        System.out.printf("Number of quadratic probe collisions:  %d\n", quadTable.quadraticCollisions);
        System.out.printf("Number of double hashing collisions:   %d\n", doubleTable.doublehashCollisions);
    }
}
