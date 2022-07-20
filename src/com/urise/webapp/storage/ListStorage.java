package com.urise.webapp.storage;


import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListStorage extends AbstractStorage {

    List<Resume> storage = new ArrayList<>();

    @Override
    public void clear() {
        storage.clear();
    }

    protected void doSave(Resume r, Object searchKey) {
        storage.add(r);
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        storage.set((Integer) findSearchKey(r.getUuid()), r);
    }

    protected void doDelete(Object searchKey) {
        storage.remove((int) searchKey);
    }

    protected Resume doGet(Object searchKey) {
        return storage.get((Integer) searchKey);
    }

    public Resume[] getAll() {
        return storage.toArray(new Resume[0]);
    }

    public int getSize() {
        return storage.size();
    }

    protected Object findSearchKey(String uuid) {
        for (Resume r : storage) {
            if (r.getUuid().equals(uuid)) {
                return storage.indexOf(r);
            }
        }
        return -1;
    }

    public boolean isExist(Object searchKey) {
        int index = (Integer) searchKey;
        return index >= 0;
    }
    public List<Resume> doSortList() {
        List<Resume> list = storage;
        Collections.sort(list);
        return list;
    }
}



