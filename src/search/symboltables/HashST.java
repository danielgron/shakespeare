
package search.symboltables;

/**
 *
 * @author Cherry Rose Semeña
 */
public class HashST <K,V> {
    private int size;
    private LinkedST<K, V>[] st;
    
    public HashST() {
        this(997);
    }

    public HashST(int tSize) {
        this.size = tSize;
        st = (LinkedST<K, V>[]) new LinkedST[tSize];
        for (int i = 0; i < tSize; i++) {
            st[i] = new LinkedST();
        }
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % size;
    }

    public V get(K key) {
        return st[hash(key)].get(key);
    }

    public void put(K key, V val) {
        st[hash(key)].put(key, val); 
    }
    
    public void print() {
        
        for (int i = 0; i < st.length; i++) {
           st[i].print();
        }
        
    }

    boolean contains(K word) {
        return get(word) != null;
    }
}
