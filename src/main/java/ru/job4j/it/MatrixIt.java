package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;
    private int rowNext = 0;
    private int columnNext = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        rowNext = row;
        columnNext = column;
        while (true) {
            if (rowNext < data.length) {
                if (columnNext < data[rowNext].length) {
                    return true;
                } else {
                    columnNext = 0;
                    rowNext++;
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
        row = rowNext;
        column = columnNext;
        return data[row][column++];
    }
}
