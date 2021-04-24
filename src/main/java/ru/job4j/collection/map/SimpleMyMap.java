package ru.job4j.collection.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMyMap<Key, Value> implements Iterable<SimpleMyMap.Node<Key, Value>> {

    private int size = 0;
    private int countMod = 0;
    private Node<Key, Value>[] data;

    public SimpleMyMap(int capacity) {
        data = new Node[capacity];
    }

    public boolean insert(Key key, Value value) {
        if (insert(key, value, data)) {
            size++;
            changeSize();
            countMod++;
            return true;
        }
        return false;
    }

    private boolean insert(Key key, Value value, Node<Key, Value>[] nodes) {
        int index = index(key, nodes);
        boolean flag = false;
        if (nodes[index] == null) {
            nodes[index] = new Node<>(key, value);
            flag = true;
        } else if (nodes[index].key.hashCode() == key.hashCode()) {
            nodes[index].value = value;
            flag = true;
        }
        return flag;
    }

    public Value get(Key key) {
        int index = index(key, data);
        if (data[index] == null) {
            return null;
        }
        return data[index].value;
    }

    public boolean delete(Key key) {
        int index = index(key, data);
        if (data[index] == null) {
            return false;
        }
        data[index] = null;
        size--;
        countMod++;
        return true;
    }

    private int index(Key key, Node<Key, Value>[] nodes) {
        return hash(key, nodes) & (nodes.length - 1);
    }

    private int hash(Key key, Node<Key, Value>[] nodes) {
        return key == null ? 0 : key.hashCode();
        //return h = h ^ (h >>> 16);
    }

    private void changeSize() {
        float loadFactor = 0.75F;
        if (size > data.length * loadFactor) {
            Node<Key, Value>[] newData = new Node[data.length * 2];
            for (Node<Key, Value> node : data) {
                if (node != null) {
                    insert(node.key, node.value, newData);
                }
            }
            data = newData;
        }
    }

    static class Node<Key, Value> {
        private final Key key;
        private Value value;
        //private Node<Key, Value> nextNode = null;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

        public Key getKey() {
            return key;
        }

        public Value getValue() {
            return value;
        }
    }

    @Override
    public Iterator<SimpleMyMap.Node<Key, Value>> iterator() {
        return new Iterator<>() {

            private final int countModException = countMod;
            private int cursor = 0;
            private int index = 0;

            @Override
            public boolean hasNext() {
                if (countMod != countModException) {
                    throw new ConcurrentModificationException();
                }
                return cursor < size;
            }

            @Override
            public Node<Key, Value> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                while (data[index] == null) {
                    index++;
                }
                cursor++;
                return data[index++];
            }
        };
    }
}
