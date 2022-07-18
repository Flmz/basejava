package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    @Override
    public void save(Resume r) {
        int index = findExistingKey(r.getUuid());
        doSave(r, index);
    }

    @Override
    public void delete(String uuid) {
        int index = findNotExistingKey(uuid);
        doDelete(index);
    }

    public Resume get(String uuid) {
        int index = findNotExistingKey(uuid);
        return doGet(index);
    }

    public void update(Resume r) {
        int index = findNotExistingKey(r.getUuid());
        doUpdate(r, index);
    }

    public boolean isExist(Object searchKey) {
        int index = (Integer) searchKey;
        return index >= 0;
    }

    protected int findExistingKey(String uuid) {
        if (isExist(findSearchKey(uuid))) {
            throw new ExistStorageException(uuid);
        } else {
            return (Integer) findSearchKey(uuid);
        }
    }

    protected int findNotExistingKey(String uuid) {

        if (isExist(findSearchKey(uuid))) {
            return (Integer) findSearchKey(uuid);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    protected abstract Resume doGet(int index);

    protected abstract void doDelete(int index);

    protected abstract void doSave(Resume r, int index);

    protected abstract void doUpdate(Resume r, int index);

    protected abstract Object findSearchKey(String uuid);

    public abstract void addElement(Resume r, int index);

    public abstract void deleteElement(int index);

    public abstract void clear();

    public abstract Resume[] getAll();
}

