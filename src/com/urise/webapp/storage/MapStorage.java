package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    Map<String, Resume> storage = new HashMap<>();

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
        storage.remove(((Resume) resume).getUuid());
    }

    protected Resume doGet(Object resume) {
        return (Resume) resume;
    }

    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int getSize() {
        return storage.size();
    }

    public Object findSearchKey(String uuid) {
        return storage.get(uuid);
    }

    public boolean isExist(Object searchKey) {
        return searchKey != null;
    }
}
