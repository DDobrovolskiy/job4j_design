package ru.job4j.collection;

import ru.job4j.collection.SimpleArray;

import java.util.Iterator;

public class SimpleSet<T> implements Set<T> {

    private SimpleArray<T> set = new SimpleArray<>();

    @Override
    public boolean add(T value) {
         if (contains(value)) {
             return false;
         }
        set.add(value);
        return true;
    }

    @Override
    public boolean contains(T value) {
        for (T item : set) {
            if (value != null) {
                if (value.equals(item)) {
                    return true;
                }
            } else {
                if (value == item) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
