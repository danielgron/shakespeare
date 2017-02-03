
package shakespeare;

/**
 *
 * @author Cherry Rose Semeña
 */
public class MergeSort {
    public static String[] mergeSort(String[] data){
        if (data.length <= 1) {
            return data;
        }
        
        String[] arr1 = new String[data.length/2];
        String[] arr2 = new String[(data.length - arr1.length)];
        System.arraycopy(data, 0, arr1, 0, arr1.length);
        System.arraycopy(data,arr1.length, arr2,0, arr2.length);
        
        mergeSort(arr1);
        mergeSort(arr2);
        
        merge(arr1,arr2,data);
        return data;
    }

    private static void merge(String[] arr1, String[] arr2, String[] data) {
    
       int a = 0;
        int b = 0;
        for (int i = 0; i < data.length; i++) {
            if (b >= arr2.length || (a < arr1.length && arr1[a].compareTo(arr2[b]) < 0)) {
                data[i] = arr1[a];
                a++;
            } else {
                data[i] = arr2[b];
                b++;
            }
        }
    }
}
