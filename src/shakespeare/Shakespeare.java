/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakespeare;

import dk.cphbusiness.shakespeare.FileUtility;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
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
            String[] partialShakespeare = getPartialArray(array,1000);
            // Selection
            
            String[] selectionSorted = SelectionSort.selectionSort(partialShakespeare);
            for (String string : selectionSorted) {
                System.out.println(string);
            }
            // Insertion
            
            // Merge
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
    
}
