package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {



    @Override
    public void save(Resume r) {
        int index = findIndex(r.getUuid());
        if (!saveExist(r)) {
            throw new ExistStorageException(r.getUuid());
        } else {
            addElement(r,index);
        }
    }
    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return doGet(index);
    }

    @Override
    public void update(Resume r) {
        if (!checkNotExist(r)) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            doUpdate(r, findIndex(r.getUuid()));
        }
    }

    @Override
    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            deleteElement(index);
        }
    }

    @Override
    public abstract Resume[] getAll();

    public boolean checkNotExist(Resume r) {
        int index = findIndex(r.getUuid());
        if (index < 0) {
            return false;
        }
        return true;
    }

    public boolean saveExist(Resume r) {
        int index = findIndex(r.getUuid());
        if (index >= 0) {
            return false;
        }
        return true;
    }

    public abstract void clearStorage();

    protected abstract Resume doGet(int index);

    protected abstract int findIndex(String uuid);

    public abstract void addElement(Resume r, int index);

    public abstract void deleteElement(int index);

    public abstract void doUpdate(Resume r, int index);
}

