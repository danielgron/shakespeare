/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakespeare;

import shakespeare.sort.SelectionSort;
import shakespeare.sort.MergeSortBU;
import shakespeare.sort.MergeSortTD;
import shakespeare.sort.InsertionSort;
import dk.cphbusiness.shakespeare.FileUtility;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class Shakespeare {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Read text file to array
        try {
            String[] array = FileUtility.toStringArray("shakespeare-complete-works.txt", "[^A-Za-z]");
            String[] partialShakespeare = getPartialArray(array,100000);
            // Selection
            Stopwatch selTimer = new Stopwatch();
            String[] selectionSorted = SelectionSort.selectionSort(partialShakespeare);
            System.out.println("Selection Sort TIME:" + selTimer.elapsedTime()+"s");
//            for (String string : selectionSorted) {
//                System.out.println(string);
//            }
            // Insertion
            Stopwatch insTimer = new Stopwatch();
            String[] res = InsertionSort.insertionSort(partialShakespeare);
            System.out.println("Insertion Sort TIME:" + insTimer.elapsedTime()+"s");
//            for (int i = 0; i < res.length; i++) {
//                System.out.println(res[i]);
//            }
            
            // Merge
            Stopwatch merTimer = new Stopwatch();
            String[] merSorted = MergeSortBU.sort(partialShakespeare);
            System.out.println("Merge Sort Bottom-up TIME:" + merTimer.elapsedTime()+"s");
            
            Stopwatch mer2Timer = new Stopwatch();
            String[] mer2Sorted = MergeSortTD.sort(partialShakespeare);
            System.out.println("Merge Sort Top-Down TIME:" + mer2Timer.elapsedTime()+"s");
            
//            for (String str : mer2Sorted) {
//                System.out.println(str);
//            }
        } catch (IOException ex) {
            Logger.getLogger(Shakespeare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static String[] getPartialArray(String[] array, int size){
        String[] toReturn = new String[size];
        for (int i = 0; i < size; i++) {
            toReturn[i]=array[i];
        }
        return toReturn;
    }
    
    //just a helper method if already sorted
    public static boolean isSorted(int limit, String[] words) {
        if (limit <= 0 || words.length < limit) {
            limit = words.length;
        }
        String temp = words[0];
        for (int i = 1; i < limit; i++) {
            if (temp.compareTo(words[i]) > 0) {
                return false;
            }
            temp = words[i];
        }
        return true;
    }
    
}
