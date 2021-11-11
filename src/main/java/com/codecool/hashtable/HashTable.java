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
            buckets.add(new LinkedList<>()); // <= we dont need to add Entry for it
        }
    }

    private int getBucketIndexForKey(K key) {
        return Math.abs(key.hashCode() % bucketsSize);
    }

    private List<Entry> getBucketAtIndex(int position) {
        throw new RuntimeException("FIXME");
    }

    private Entry findEntryInBucket(K key, List<Entry> bucket) {
        throw new RuntimeException("FIXME");
    }

    public boolean isOverrideValue(K key, V value, int oustsideListindex){
        LinkedList<Entry> insideList = (LinkedList<Entry>) buckets.get(oustsideListindex);
        for (int i = 0; i < insideList.size(); i++) {
            if (insideList.get(i).key == key ){
                insideList.get(i).value = value;
                return true;
            }
        }
        return false;
    }

    public V get(K key) {
        int outsideListIndex;
        if (key == null){
            outsideListIndex = 0;
        }else {
            outsideListIndex = getBucketIndexForKey(key);
        }
        LinkedList<Entry> insideList = (LinkedList<Entry>) buckets.get(outsideListIndex);
        for (Entry entry : insideList) {
            if (entry.key == key) {
                return (V) entry.value; // <=    check with mentor
            }
        }
        return null;
    }

    public void put(K key, V value) {
        int outListIndex;
        if (key == null){
            outListIndex = 0;
        }else {
            outListIndex = getBucketIndexForKey(key);
        }
        if (!isOverrideValue(key, value, outListIndex)){
            Entry<K, V> newElement = new Entry<>(key, value);
            buckets.get(outListIndex).add(newElement);
        }
    }

    public V remove(K key) {
        V ramovedValue = null;
        int outListIndex;
        if (key == null){
            outListIndex = 0;
        }else {
            outListIndex = getBucketIndexForKey(key);
        }
        LinkedList<Entry> insideList = (LinkedList<Entry>) buckets.get(outListIndex);
        for (int i = 0; i <insideList.size() ; i++) {
            if (insideList.get(i).key == key){
                ramovedValue = (V) insideList.get(i).value;
                insideList.remove(insideList.get(i));
            }
        }
        return ramovedValue;
    }

    public void clear() {
        buckets = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            buckets.add(new LinkedList<>()); // <= we dont need to add Entry for it
        };
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
