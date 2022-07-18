package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void addElement(Resume r, int index) {
        int indexOfElement = (index * -1) - 1;
        System.arraycopy(storage, indexOfElement, storage, indexOfElement + 1, size - indexOfElement);
        storage[indexOfElement] = r;
        size++;
    }

    @Override
    public void deleteElement(int index) {
        int elementsToMove = size - index - 1;
        if (elementsToMove > 0) {
            System.arraycopy(storage, index + 1, storage, index, elementsToMove);
            storage[size - 1] = null;
            size--;
        }
    }

    @Override
    protected Object findSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}

