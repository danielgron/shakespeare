package search.symboltables;

/**
 *
 * @author Cherry Rose Semeña
 */
public class ArrayST<K, V> {

    private K[] keys;
    private V[] values;
    private int n = 0;

    private int startSize = 1;

    public ArrayST() {
        keys = (K[]) new Object[startSize];
        values = (V[]) new Object[startSize];
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    private void resize(int size) {
        K[] tempkey = (K[]) new Object[size];
        V[] tempval = (V[]) new Object[size];

        for (int i = 0; i < n; i++) {
            tempkey[i] = keys[i];
        }

        for (int i = 0; i < n; i++) {
            tempval[i] = values[i];
        }

        keys = tempkey;
        values = tempval;

    }

    public void put(K key, V val) {
        int i;

        for (i = 0; i < n; i++) {
            if (key.equals(keys[i])) {
                values[i] = val;
                break;
            }
        }

        if (n >= values.length) {

            resize(2 * n);
        } else {
            values[i] = val;
            keys[i] = key;
            if (i == n) {
                n++;
            }
        }
    }

    public V get(K key) {
        for (int i = 0; i < n; i++) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    public void print() {
//        System.out.println("AST" + n);
//System.out.println("AST" + values[0]);
        for (int i = 0; i < n; i++) {

            System.out.println(keys[i] + " - " + values[i]);
        }
    }

    public boolean contains(K word) {
        return get(word) != null;
    }

}
