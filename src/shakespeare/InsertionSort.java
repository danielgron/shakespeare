/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakespeare;

/**
 *
 * @author Cherry Rose Semeña
 */
public class InsertionSort {

    public static String[] insertionSort(String[] data){
        int j;
        int i;
        String temp;
        
        for(j=1; j<data.length; j++){
            temp = data[j];
            for (i = j-1; (i >= 0) && ((data[i].compareTo(temp)) >= 0); i--){
                data[i+1] = data[i];
            }
             data[i+1] = temp; 
        }
        
        return data;
    }
    
    
}
