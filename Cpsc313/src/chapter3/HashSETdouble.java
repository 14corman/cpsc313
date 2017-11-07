package chapter3;

import edu.princeton.cs.algs4.Queue;
import java.util.Arrays;

/**
 *
 * @author cjedwards1
 * Problem 3.5.6
 */
public class HashSETdouble {
private static final int INIT_CAPACITY = 4;

    private int n;           // number of key-value pairs in the symbol table
    private int m;           // size of linear probing table
    private double[] keys;      // the keys

    public HashSETdouble() {
        this(INIT_CAPACITY);
    }

    public HashSETdouble(int capacity) {
        m = capacity;
        n = 0;
        keys = new double[m];
        Arrays.fill(keys, Double.MIN_VALUE);
    }

    public double size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(double key) {
        return get(key);
    }

    private int hash(double key) {
        return (Double.valueOf(key).hashCode() & 0x7fffffff) % m;
    }

    private void resize(int capacity) {
        HashSETdouble temp = new HashSETdouble(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != Double.MIN_VALUE) {
                temp.put(keys[i]);
            }
        }
        keys = temp.keys;
        m    = temp.m;
    }

    public void put(double key) {
        if (key == Double.MIN_VALUE) throw new IllegalArgumentException("first argument to put() is null");

        // double table size if 50% full
        if (n >= m/2) resize(2*m);

        int i;
        for (i = hash(key); keys[i] != Double.MIN_VALUE; i = (i + 1) % m) {
            if (keys[i] == key) {
                return;
            }
        }
        keys[i] = key;
        n++;
    }

    private boolean get(double key) {
        if (key == Double.MIN_VALUE) throw new IllegalArgumentException("argument to get() is null");
        for (int i = hash(key); keys[i] != Double.MIN_VALUE; i = (i + 1) % m)
            if (keys[i] == key)
                return true;
        return false;
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

        // rehash all keys in same cluster
        i = (i + 1) % m;
        while (keys[i] != Double.MIN_VALUE) {
            // delete keys[i] an vals[i] and reinsert
            double   keyToRehash = keys[i];
            keys[i] = Double.MIN_VALUE;
            n--;
            put(keyToRehash);
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
            else if (get(keys[i])) {
                System.err.println("get[" + keys[i] + "] = " + get(keys[i]) + ";");
                return false;
            }
        }
        return true;
    }
}
