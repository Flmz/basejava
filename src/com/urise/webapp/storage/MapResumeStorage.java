package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage {

    private final Map<String, Resume> storage = new HashMap<>();

    protected void doSave(Resume r, Object searchKey) {
        storage.put(r.getUuid(), r);
    }

    public void clear() {
        storage.clear();
    }

    protected void doUpdate(Resume r, Object searchKey) {
        storage.put(r.getUuid(), r);
    }

    protected void doDelete(Object resume) {
        storage.remove(((Resume) resume).getUuid());
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

    @Override
    public void update(Resume r) {
        Object searchKey = findNotExistingKey(r.getUuid());
        doUpdate(r, searchKey);
    }

    public List<Resume> doSortList() {
        return new ArrayList<>(storage.values());
    }
}

