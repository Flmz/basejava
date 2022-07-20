package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageExeption;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

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

    protected void doDelete(Object searchKey) {
        deleteElement((Integer) searchKey);
        size--;
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        storage[(Integer) searchKey] = r;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    public void doSave(Resume r, Object searchKey) {
        if (size == STORAGE_LIMIT) {
            throw new StorageExeption("Storage overflow", r.getUuid());
        }
        addElement(r, searchKey);
        size++;
    }

    public boolean isExist(Object searchKey) {
        int index = (Integer) searchKey;
        return index >= 0;
    }

    protected Resume doGet(Object searchKey) {
        return storage[(Integer) searchKey];
    }

    public int getSize() {
        return size;
    }

    public List<Resume> doSortList(){
        return Arrays.asList(Arrays.copyOfRange(storage, 0, size));
    }

    protected abstract Object findSearchKey(String uuid);

    public abstract void addElement(Resume r, Object searchKey);

    public abstract void deleteElement(int index);
}




