package chapter3;

import edu.princeton.cs.algs4.Queue;
import java.util.Arrays;

/**
 *
 * @author cjedwards1
 * Problem 3.5.4
 */
public class HashSTdouble<Value> {
    private static final int INIT_CAPACITY = 4;

    private int n;           // number of key-value pairs in the symbol table
    private int m;           // size of linear probing table
    private double[] keys;      // the keys
    private Value[] vals;    // the values

    public HashSTdouble() {
        this(INIT_CAPACITY);
    }

    public HashSTdouble(int capacity) {
        m = capacity;
        n = 0;
        keys = new double[m];
        Arrays.fill(keys, Double.MIN_VALUE);
        vals = (Value[]) new Object[m];
    }

    public double size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(double key) {
        return get(key) != null;
    }

    // hash function for keys - returns value between 0 and M-1
    private int hash(double key) {
        return (Double.valueOf(key).hashCode() & 0x7fffffff) % m;
    }

    // resizes the hash table to the given capacity by re-hashing all of the keys
    private void resize(int capacity) {
        HashSTdouble<Value> temp = new HashSTdouble(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != Double.MIN_VALUE) {
                temp.put(keys[i], vals[i]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        m    = temp.m;
    }

    public void put(double key, Value val) {
        if (key == Double.MIN_VALUE) throw new IllegalArgumentException("first argument to put() is null");

        if (val == null) {
            delete(key);
            return;
        }

        // double table size if 50% full
        if (n >= m/2) resize(2*m);

        int i;
        for (i = hash(key); keys[i] != Double.MIN_VALUE; i = (i + 1) % m) {
            if (keys[i] == key) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }

    public Value get(double key) {
        if (key == Double.MIN_VALUE) throw new IllegalArgumentException("argument to get() is null");
        for (int i = hash(key); keys[i] != Double.MIN_VALUE; i = (i + 1) % m)
            if (keys[i] == key)
                return vals[i];
        return null;
    }

    public void delete(double key) {
        if (key == Double.MIN_VALUE) throw new IllegalArgumentException("argument to delete() is null");
        if (!contains(key)) return;

        // find position i of key
        int i = hash(key);
        while (key != keys[i]) {
            i = (i + 1) % m;
        }

        // delete key and associated value
        keys[i] = Double.MIN_VALUE;
        vals[i] = null;

        // rehash all keys in same cluster
        i = (i + 1) % m;
        while (keys[i] != Double.MIN_VALUE) {
            // delete keys[i] an vals[i] and reinsert
            double   keyToRehash = keys[i];
            Value valToRehash = vals[i];
            keys[i] = Double.MIN_VALUE;
            vals[i] = null;
            n--;
            put(keyToRehash, valToRehash);
            i = (i + 1) % m;
        }

        n--;

        // halves size of array if it's 12.5% full or less
        if (n > 0 && n <= m/8) resize(m/2);

        assert check();
    }

    public Iterable<Double> keys() {
        Queue<Double> queue = new Queue();
        for (int i = 0; i < m; i++)
            if (keys[i] != Double.MIN_VALUE) queue.enqueue(keys[i]);
        return queue;
    }

    private boolean check() {

        // check that hash table is at most 50% full
        if (m < 2*n) {
            System.err.println("Hash table size m = " + m + "; array size n = " + n);
            return false;
        }

        // check that each key in table can be found by get()
        for (int i = 0; i < m; i++) {
            if (keys[i] == Double.MIN_VALUE) continue;
            else if (get(keys[i]) != vals[i]) {
                System.err.println("get[" + keys[i] + "] = " + get(keys[i]) + "; vals[i] = " + vals[i]);
                return false;
            }
        }
        return true;
    }
}
