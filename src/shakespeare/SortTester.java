/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakespeare;

import shakespeare.sort.SelectionSort;

/**
 *
 * @author danie
 */
public class SortTester {
    public static void main(String[] args) {
        String[] testArray = {"cow","tiger","panda","cow","bison","goat","cow","emu","cow","cat","dog","anaconda"};
        String[] testResult = SelectionSort.selectionSortWithPrint(testArray);
        for (String string : testResult) {
            System.out.println(string);
        }
    }
}
