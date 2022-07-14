package com.urise.webapp.storage;


import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    List<Resume> storage = new ArrayList<>();

    @Override
    public void clearStorage() {
        storage.clear();
    }

    @Override
    public void update(Resume r) {
        if (!checkNotExist(r)) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            storage.set(findIndex(r.getUuid()), r);
        }
    }

    @Override
    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return storage.get(index);
    }

    public Resume[] getAll() {
        return storage.toArray(new Resume[0]);
    }

    @Override
    public void save(Resume r) {
        if (!saveExist(r)) {
            throw new ExistStorageException(r.getUuid());
        } else {
            storage.add(r);
        }
    }

    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            storage.remove(index);
        }
    }

    @Override
    public int getSize() {
        return storage.size();
    }

    @Override
    protected int findIndex(String uuid) {
        for (Resume r : storage) {
            if (r.getUuid().equals(uuid)) {
                return storage.indexOf(r);
            }
        }
        return -1;
    }

}

