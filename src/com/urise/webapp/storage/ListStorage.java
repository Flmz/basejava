package com.urise.webapp.storage;


import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    List<Resume> storage = new ArrayList<>();

    @Override
    public void clear() {
        storage.clear();
    }

    protected void doSave(Resume r, int index) {
        addElement(r, index);
    }

    @Override
    protected void doUpdate(Resume r, int index) {
        storage.set((int) findSearchKey(r.getUuid()), r);
    }

    protected void doDelete(int index) {
        deleteElement(index);
    }

    protected Resume doGet(int index) {
        return storage.get(index);
    }

    public Resume[] getAll() {
        return storage.toArray(new Resume[0]);
    }

    @Override
    public int getSize() {
        return storage.size();
    }

    @Override
    protected Object findSearchKey(String uuid) {
        for (Resume r : storage) {
            if (r.getUuid().equals(uuid)) {
                return storage.indexOf(r);
            }
        }
        return -1;
    }

    @Override
    public void addElement(Resume r, int index) {
        storage.add(r);
    }

    @Override
    public void deleteElement(int index) {
        storage.remove(index);
    }
}



