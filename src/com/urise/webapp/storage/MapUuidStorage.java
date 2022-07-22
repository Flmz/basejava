package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage {

    private final Map<String, Resume> storage = new HashMap<>();

    protected void doSave(Resume r, Object searchKey) {
        storage.put(r.getUuid(), r);
    }

    public void clear() {
        storage.clear();
    }

    protected void doUpdate(Resume r, Object searchKey) {
        storage.replace(r.getUuid(), r);
    }

    protected void doDelete(Object resume) {
        storage.remove(resume);
    }

    protected Resume doGet(Object resume) {
        return storage.get(resume);
    }

    public int getSize() {
        return storage.size();
    }

    public Object findSearchKey(String uuid) {
        return uuid;
    }

    public boolean isExist(Object searchKey) {
        return storage.containsKey(searchKey);
    }

    public List<Resume> doCopyAll() {
        return new ArrayList<>(storage.values());
    }
}
