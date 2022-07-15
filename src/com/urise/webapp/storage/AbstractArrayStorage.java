package com.urise.webapp.storage;

import com.urise.webapp.exception.*;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {

    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    protected int size;

    @Override
    public void clearStorage() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    public void save(Resume r) {
        int index = findIndex(r.getUuid());
        if (!saveExist(r)) {
            throw new ExistStorageException(r.getUuid());
        } else if (size == STORAGE_LIMIT) {
            throw new StorageExeption("Storage overflow", r.getUuid());
        } else {
            addElement(r, index);
            size++;
        }
    }


    protected Resume doGet(int index) {
        return storage[index];
    }

    public int getSize() {
        return size;
    }

    protected abstract int findIndex(String uuid);

    public abstract void addElement(Resume r, int index);

    public abstract void deleteElement(int index);
}


