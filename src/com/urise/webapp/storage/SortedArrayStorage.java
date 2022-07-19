package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    public void addElement(Resume r, Object searchKey) {
        int indexOfElement = ((int) (searchKey) * -1) - 1;
        System.arraycopy(storage, indexOfElement, storage, indexOfElement + 1, size - indexOfElement);
        storage[indexOfElement] = r;

    }

    @Override
    public void deleteElement(int index) {
        int elementsToMove = size - index - 1;
        if (elementsToMove > 0) {
            System.arraycopy(storage, index + 1, storage, index, elementsToMove);
            storage[size - 1] = null;
        }
    }

    @Override
    protected Object findSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}

