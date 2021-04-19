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
        while (true) {
            if (cursorNext < data.length) {
                if (data[cursorNext] % 2 == 0) {
                    return true;
                } else {
                    cursorNext++;
                }
            } else {
                return false;
            }
        }
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
