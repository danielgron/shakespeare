/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakespeare.sort;

/**
 *
 * @author danie
 */
public class SelectionSort {

    public static String[] selectionSort(String[] input) {
        for (int i = 0; i < input.length; i++) {
            int smallestPos = i;
            for (int j = i; j < input.length; j++) {
                if (input[smallestPos].compareTo(input[j]) > 0) {
                    smallestPos = j;
                }
            }
            if (smallestPos != i) {
                String temp = input[i];
                input[i] = input[smallestPos];
                input[smallestPos] = temp;
            }

        }
            return input;
    }
    
    

    public static String[] selectionSortWithPrint(String[] input) {
        for (int i = 0; i < input.length; i++) {
            // Start by considering the next item the smallest (so far) for next iteration
            int smallestPos = i;
            // Everything before i is sorted, so each iteration of inner loop should start from current i
            for (int j = i; j < input.length; j++) {

                // if we find a smaller number, save the index position
                if (input[smallestPos].compareTo(input[j]) > 0) {
                    smallestPos = j;
                }
            }
            // If smallestPos is no longer the same it means we found a lower number and have to swap
            if (smallestPos != i) {
                System.out.println("Swapping " + input[i] + " with " + input[smallestPos]);
                String temp = input[i];
                input[i] = input[smallestPos];
                input[smallestPos] = temp;
            }
            // Rest are prints for testing
            System.out.println("Array is now: ");
            for (int k = 0; k < input.length; k++) {
                System.out.print(" -" + input[k] + "- ");
            }
            System.out.print("\n");
        }
        System.out.println("Sorted array: ");
        for (int i = 0; i < input.length; i++) {
            System.out.print(" -" + input[i] + "- ");
        }
        System.out.print("\n");

        return input;
    }
}
