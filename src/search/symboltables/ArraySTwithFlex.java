/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search.symboltables;

/**
 *
 * @author Cherry Rose Semeña
 */
public class ArraySTwithFlex <K, V> {
    private FlexibleArray<K> keys;
    private FlexibleArray<V> values;
    private int n = 0;


    public ArraySTwithFlex() {
        keys = new FlexibleArray<>();
        values = new FlexibleArray<>();
    }

    public int size() {
        return n;
    }

//    public boolean isEmpty() {
//        return n == 0;
//    }

//    private void resize(int size) {
//        K[] tempkey = (K[]) new Object[size];
//        V[] tempval = (V[]) new Object[size];
//
//        for (int i = 0; i < n; i++) {
//            tempkey[i] = keys[i];
//        }
//
//        for (int i = 0; i < n; i++) {
//            tempval[i] = values[i];
//        }
//
//        keys = tempkey;
//        values = tempval;
//
//    }

    public void put(K key, V val) {
//        for (int i = 0; i < n; i++) {
//            if (key.equals(keys.get(i))) {
//                values.set(i, val);
//                break;
//            }
//        }

        for (int i = 0; i < keys.size(); i++)
        {
            if (key.equals(keys.get(i)))
            {
                values.set(i, val);
                return;
            }
        }
        if (n >= values.size()) {
            
            for (int j = 0; j < values.size(); j++) {
                values.add(values.get(j));
                values.set(j, val);
            }
            for (int k = 0; k < keys.size(); k++) {
                keys.add(keys.get(k));
                keys.set(k, key);
            }
//            values.add(val);
//            keys.add(key);
//            values.set(n, val);
//            keys.set(n, key);
//            n++;
            
        } else {
            System.out.println("HERE");
            values.set(n, val);
            keys.set(n, key);
            n++;
        }
    }

    public V get(K key) {
        for (int i = 0; i < n; i++) {
            if (key.equals(keys.get(i))) {
                return values.get(i);
            }
        }
        return null;
    }

    public void print() {
        
        System.out.println(n);
        for (int i = 0; i < n; i++) {

            System.out.println(keys.get(i) + " - " + values.get(i));
        }
    }

    public boolean contains(K word) {
        return get(word) != null;
    }
}
