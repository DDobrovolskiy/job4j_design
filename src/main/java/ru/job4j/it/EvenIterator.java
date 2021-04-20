package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {

    private final int[] data;
    private int cursor = 0;
    private int cursorNext = 0;

    public EvenIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        cursorNext = cursor;
        while (!(data[cursorNext] % 2 == 0)) {
            cursorNext++;
            if (cursorNext == data.length) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        cursor = cursorNext;
        return data[cursor++];
    }
}
