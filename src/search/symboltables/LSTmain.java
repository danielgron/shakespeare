package search.symboltables;

import dk.cphbusiness.shakespeare.FileUtility;

/**
 *
 * @author Cherry Rose Semeña
 */
public class LSTmain {

    public static void main(String[] args) {
        try {
            String[] array = FileUtility.toStringArray("shakespeare-complete-works.txt", "[^A-Za-z]");
            String[] partialShakespeare = getPartialArray(array, 100000);
            
            doLinkedST(partialShakespeare);
            
        } catch (Exception ex) {
            System.out.println("ERROR:" + ex.getMessage());
        }
        
    }
    
    public static void doLinkedST(String[] partialShakespeare) {
        
        LinkedSymbolTable<String, Integer> lst = new LinkedSymbolTable<>();
        for (String word : partialShakespeare) {
            if (!lst.contains(word)) {
                lst.put(word, 1);
            } else {
                lst.put(word, lst.get(word) + 1);
            }
        }
        
        lst.print();
    }
    
    public static String[] getPartialArray(String[] array, int size) {
        String[] toReturn = new String[size];
        for (int i = 0; i < size; i++) {
            toReturn[i] = array[i];
        }
        return toReturn;
    }
}
