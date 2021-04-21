package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = findIndexById(id);
        return mem.get(index).equals(mem.set(index, model));
    }

    @Override
    public boolean delete(String id) {
        int index = findIndexById(id);
        return mem.get(index).equals(mem.remove(index));
    }

    @Override
    public int findIndexById(String id) {
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public T findById(String id) {
        for (T item : mem) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }
}
