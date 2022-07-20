package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapFullNameStorage extends AbstractStorage {

    private final Map<String, Resume> storage = new HashMap<>();

    protected void doSave(Resume r, Object searchKey) {
        storage.put(r.getFullName(), r);
    }

    public void clear() {
        storage.clear();
    }

    @Override
    public void save(Resume r) {
        Object searchKey = findExistingKey(r.getFullName());
        doSave(r, searchKey);
    }

    @Override
    public void update(Resume r) {
        Object searchKey = findNotExistingKey(r.getFullName());
        doUpdate(r, searchKey);
    }

    public List<Resume> getAllSorted() {
        return new ArrayList<>(storage.values());
    }

    protected void doUpdate(Resume r, Object searchKey) {
        storage.put(r.getFullName(), r);
    }

    protected void doDelete(Object resume) {
        storage.remove(((Resume) resume).getFullName());
    }

    protected Resume doGet(Object resume) {
        return (Resume) resume;
    }

    public int getSize() {
        return storage.size();
    }

    public Object findSearchKey(String key) {
        return storage.get(key);
    }

    public boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    public List<Resume> doSortList() {
        return new ArrayList<>(storage.values());
    }
}

