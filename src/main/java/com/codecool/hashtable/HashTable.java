package com.codecool.hashtable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTable<K, V> {


    // Number of all buckets - Do not modify!
    private final int bucketsSize = 16;


    public List<List<Entry>> buckets;

    public HashTable() {
        buckets = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            buckets.add(new LinkedList<>());
        }
    }

    private int getBucketIndexForKey(K key) {
        throw new RuntimeException("FIXME");
    }

    private List<Entry> getBucketAtIndex(int position) {
        throw new RuntimeException("FIXME");
    }

    private Entry findEntryInBucket(K key, List<Entry> bucket) {
        throw new RuntimeException("FIXME");
    }

    public V get(K key) {
        int outsideListIndex;
        if (key == null){
            outsideListIndex = 0;
        }else {
            outsideListIndex = getHashValu(key);
        }
        LinkedList<Entry> insideList = (LinkedList<Entry>) buckets.get(outsideListIndex);
        for (Entry entry : insideList) {
            if (entry.key == key) {
                return (V) entry.value;
            }
        }
        return null;
    }

    public void put(K key, V value) {
        int outListIndex;
        if (key == null){
            outListIndex = 0;
        }else {
            outListIndex = getHashValu(key);
        }
        Entry<K, V> newElement = new Entry<>(key, value);
        buckets.get(outListIndex).add(newElement);
    }

    public Integer remove(K key) {
        throw new RuntimeException("FIXME");
    }

    public void clear() {
        throw new RuntimeException("FIXME");
    }

    private int getHashValu(K key){
        return Math.abs(key.hashCode() % bucketsSize);
    }
}

class Entry<K, V> {

    public K key;
    public V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

}
