/************************************
 
 Author:         Daniel Stanev
 Course:         CS 3345.004
 Date:           21 Nov 2021
 Assignment:     Homework #03
 Version:        Java SE 11 (LTS)
 
 Description: Exercise 7.1

 Sorting the numbers 3 1 4 1 5 9 2 6 5 3 5
 using insertion sort.
 
 *************************************/

public class Problem7_1 {
    public static void main(String[] x) {
        // Data fields
        int size = 0;
        int array[] = new int[10];

        // Insertion sort calls
        size = insert(array, size, 3);
        size = insert(array, size, 1);
        size = insert(array, size, 4);
        size = insert(array, size, 1);
        size = insert(array, size, 5);
        size = insert(array, size, 9);
        size = insert(array, size, 2);
        size = insert(array, size, 6);
        size = insert(array, size, 5);

        // Prints the result to check if the sort worked correctly
        for (int i = 0; i < size; i++) 
            System.out.printf("%d ", array[i]);
    
    } // end main()

    // Sorts the items as they are inserted into the array
    public static int insert(int[] array, int size, int n) {
        for (int i = 0; i <= size; i++) {
            // Shifts everything forward if the value to be inserted is smaller
            if (n < array[i]) {
                for (int j = size; j > i; j--)
                    array[j] = array[j - 1];
                array[i] = n;
                break; // leaves the loop once the insertion is complete
            } // end if 
            // inserts at last position if the end is reached
            if (i == size) {
                array[size] = n;
                break; // leaves the loop once the insertion is complete
            } // end if 
        } // end for loop
        return size + 1; // updates and returns the size
    } // end insert()
} // end class
