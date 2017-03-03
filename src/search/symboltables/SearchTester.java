package search.symboltables;

import dk.cphbusiness.shakespeare.FileUtility;
import shakespeare.Stopwatch;
import shakespeare.sort.MergeSortTD;

/**
 *
 * @author Cherry Rose Semeña
 */
public class SearchTester {

    public static void main(String[] args) {
        
        try {
            String[] array = FileUtility.toStringArray("shakespeare-complete-works.txt", "[^A-Za-z]");
            String[] partialShakespeare = getPartialArray(array, 100000);
            String[] sortedShakespeare = MergeSortTD.sort(partialShakespeare);
            
            Stopwatch lTimer = new Stopwatch();
            doLinkedST(sortedShakespeare);
            System.out.println("Linked Symbol Table: " + lTimer.elapsedTime());
            
            Stopwatch aTimer = new Stopwatch();
            doArrayST(sortedShakespeare);
            System.out.println("Array Symbol Table: " +  aTimer.elapsedTime());
            
            Stopwatch bTimer = new Stopwatch();
            doBalancedTreeST(sortedShakespeare);
            System.out.println("Balanced Tree Symbol Table: " + bTimer.elapsedTime());
            
            Stopwatch hTimer = new Stopwatch();
            doHashST(sortedShakespeare);
            System.out.println("Hash Symbol Table: " + hTimer.elapsedTime());
            
        } catch (Exception ex) {
            System.out.println("ERROR:" + ex.getMessage());
        }
        
    }
    
    public static void doLinkedST(String[] partialShakespeare) {
        
        LinkedST<String, Integer> lst = new LinkedST<>();
        for (String word : partialShakespeare) {
            if (!lst.contains(word)) {
                lst.put(word, 1);
            } else {
                lst.put(word, lst.get(word) + 1);
            }
        }
        
//        lst.print();
    }
    
    public static void doHashST(String[] partialShakespeare) {
        
        HashST<String, Integer> hst = new HashST<>();
        for (String word : partialShakespeare) {
            if (!hst.contains(word)) {
                hst.put(word, 1);
            } else {
                hst.put(word, hst.get(word) + 1);
            }
        }
        
//        hst.print();
    }
    
    public static void doArrayST(String[] partialShakespeare){
        ArrayST<String, Integer> ast = new ArrayST<>();
        for (String word : partialShakespeare) {
            if (!ast.contains(word)) {
                ast.put(word, 1);
            } else {
                ast.put(word, ast.get(word) + 1);
            }
        }
        
//        ast.print();
    }
    
    public static String[] getPartialArray(String[] array, int size) {
        String[] toReturn = new String[size];
        for (int i = 0; i < size; i++) {
            toReturn[i] = array[i];
        }
        return toReturn;
    }

    private static void doBalancedTreeST(String[] partialShakespeare) {
         BalancedTreeST<String, Integer> bst = new BalancedTreeST<>();
        for (String word : partialShakespeare) {
            if (!bst.contains(word)) {
                bst.put(word, 1);
            } else {
                bst.put(word, bst.get(word) + 1);
            }
        }
        //print
//        for (String str : bst.keys()) {
//            System.out.println(str + " : " + bst.get(str));
//        }
    }
}
