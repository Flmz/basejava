package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage<String> {

    private final Map<String, Resume> storage = new HashMap<>();

    protected void doSave(Resume r, String searchKey) {
        storage.put(r.getUuid(), r);
    }

    public void clear() {
        storage.clear();
    }

    protected void doUpdate(Resume r, String searchKey) {
        storage.replace(r.getUuid(), r);
    }

    protected void doDelete(String uuid) {
        storage.remove(uuid);
    }

    protected Resume doGet(String uuid) {
        return storage.get(uuid);
    }

    public int getSize() {
        return storage.size();
    }

    public String findSearchKey(String uuid) {
        return uuid;
    }

    public boolean isExist(String searchKey) {
        return storage.containsKey(searchKey);
    }

    public List<Resume> doCopyAll() {
        return new ArrayList<>(storage.values());
    }
}
