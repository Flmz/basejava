package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageExeption;
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
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    protected void doDelete(int index) {
        deleteElement(index);
    }

    @Override
    protected void doUpdate(Resume r, int index) {
        storage[index] = r;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    public void doSave(Resume r, int index) {
        if (size == STORAGE_LIMIT) {
            throw new StorageExeption("Storage overflow", r.getUuid());
        }
        addElement(r, index);
    }

    protected Resume doGet(int index) {
        return storage[index];
    }

    public int getSize() {
        return size;
    }

    protected abstract Object findSearchKey(String uuid);

    public abstract void addElement(Resume r, int index);

    public abstract void deleteElement(int index);
}



