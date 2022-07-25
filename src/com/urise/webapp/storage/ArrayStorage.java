package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    public void addElement(Resume r, Object searchKey) {
        storage[size] = r;
    }

    public void deleteElement(int index) {
        storage[index] = storage[size - 1];
        storage[size - 1] = null;
    }

    protected Integer findSearchKey(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}



