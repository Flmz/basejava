package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;


public class SortedArrayStorage extends AbstractArrayStorage {

    private static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getUuid);

    public void addElement(Resume r, Object searchKey) {
        int indexOfElement = ((int) (searchKey) * -1) - 1;
        System.arraycopy(storage, indexOfElement, storage, indexOfElement + 1, size - indexOfElement);
        storage[indexOfElement] = r;
    }

    public void deleteElement(int index) {
        int elementsToMove = size - index - 1;
        if (elementsToMove > 0) {
            System.arraycopy(storage, index + 1, storage, index, elementsToMove);
            storage[size - 1] = null;
        }
    }

    protected Integer findSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "name");
        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR);
    }
}

