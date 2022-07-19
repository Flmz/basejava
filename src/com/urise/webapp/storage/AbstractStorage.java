package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    @Override
    public void save(Resume r) {
        Object searchKey = findExistingKey(r.getUuid());
        doSave(r, searchKey);
    }

    @Override
    public void delete(String uuid) {
        Object searchKey = findNotExistingKey(uuid);
        doDelete(searchKey);
    }

    public Resume get(String uuid) {
        Object searchKey = findNotExistingKey(uuid);
        return doGet(searchKey);
    }

    public void update(Resume r) {
        Object searchKey = findNotExistingKey(r.getUuid());
        doUpdate(r, searchKey);
    }


    protected Object findExistingKey(String uuid) {
        if (isExist(findSearchKey(uuid))) {
            throw new ExistStorageException(uuid);
        } else {
            return findSearchKey(uuid);
        }
    }

    protected Object findNotExistingKey(String uuid) {
        if (isExist(findSearchKey(uuid))) {
            return findSearchKey(uuid);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    public abstract boolean isExist(Object searchKey);

    protected abstract Resume doGet(Object searchKey);

    protected abstract void doDelete(Object searchKey);

    protected abstract void doSave(Resume r, Object searchKey);

    protected abstract void doUpdate(Resume r, Object searchKey);

    protected abstract Object findSearchKey(String uuid);

    public abstract void clear();

    public abstract Resume[] getAll();
}

