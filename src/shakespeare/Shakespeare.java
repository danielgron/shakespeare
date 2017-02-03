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
        System.out.println(Shakespeare.class.getClassLoader().getResource("").getPath());
        InputStream inputStream = Shakespeare.class.getResourceAsStream("C:\\Users\\danie\\Desktop\\Sem4\\AlgDataStruct\\shakespeare-complete-works.txt");
        try {
            String[] array = FileUtility.toStringArray("shakespeare-complete-works.txt", "[^A-Za-z]");
            System.out.println(array[0]);
            // Ensure lower case
            // Only letters (numbers?)
            // Selection
            
            // Insertion
            InsertionSort is = new InsertionSort(array);
            String[] res = is.sort();
            for (int i = 0; i < 10; i++) {
                System.out.println(res[i]);
            }
            // Merge
        } catch (IOException ex) {
            Logger.getLogger(Shakespeare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
