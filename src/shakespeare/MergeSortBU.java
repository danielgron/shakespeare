package shakespeare;

/**
 * BOTTOM-UP MERGE SORT IMPLEMENTATION
 * @author Cherry Rose Semeña
 */
public class MergeSortBU {

    
    private static String[] aux;
    
    public static void merge(String[] data, int lo, int mid, int hi) {
    // Merge a[lo..mid] with a[mid+1..hi].  
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) // Copy a[lo..hi] to aux[lo..hi].  
        {
            aux[k] = data[k];
        }
        for (int k = lo; k <= hi; k++) // Merge back to a[lo..hi].      
        {
            if (i > mid) {
                data[k] = aux[j++];
            } else if (j > hi) {
                data[k] = aux[i++];
            } else if ((aux[j].compareTo(aux[i])) < 0) {
                data[k] = aux[j++];
            } else {
                data[k] = aux[i++];
            }
        }
    }
  
 
// auxiliary array for merges    
public static String[] sort(String[] data)   { 
    // Do lg N passes of pairwise merges.  
    int N = data.length;   
    aux = new String[N];   
    for (int sz = 1; sz < N; sz = sz+sz)   
        // sz: subarray size        
        for (int lo = 0; lo < N-sz; lo += sz+sz)
            // lo: subarray index 
            merge((String[]) data, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));  
    return data;
}



}
