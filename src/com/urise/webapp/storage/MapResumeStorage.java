package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage<Resume> {

    private final Map<String, Resume> storage = new HashMap<>();

    protected void doSave(Resume r, Resume searchKey) {
        storage.put(r.getUuid(), r);
    }

    public void clear() {
        storage.clear();
    }

    protected void doUpdate(Resume r, Resume searchKey) {
        storage.put(r.getUuid(), r);
    }

    protected void doDelete(Resume resume) {
        storage.remove(resume.getUuid());
    }

    protected Resume doGet(Resume resume) {
        return resume;
    }

    public int getSize() {
        return storage.size();
    }

    public Resume findSearchKey(String key) {
        return storage.get(key);
    }

    public boolean isExist(Resume searchKey) {
        return searchKey != null;
    }

    @Override
    public void update(Resume r) {
        Resume searchKey = findNotExistingKey(r.getUuid());
        doUpdate(r, searchKey);
    }

    public List<Resume> doCopyAll() {
        return new ArrayList<>(storage.values());
    }
}

