package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final Resume[] storage = new Resume[10000];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        int index = findIndex(r.getUuid());
        if (index == -1) {
            System.out.print("Sorry, we dont have resume with such id");
        } else {
            storage[index] = r;
        }
    }

    public void save(Resume r) {
        int index = findIndex(r.getUuid());

        if (size >= storage.length) {
            System.out.println("Sorry, storage is full");
        } else if (index > -1) {
            System.out.println("Sorry, resume with id " + r.getUuid() + " already in the storage");
        } else {
            storage[size] = r;
            size++;
        }
    }

    public Resume get(String uuid) {
        int index = findIndex(uuid);

        if (index > -1) {
            return storage[index];
        } else {
            System.out.println("There is no such resume with ID " + uuid);
            return null;
        }
    }

    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index > -1) {
            //System.arraycopy(storage, i + 1, storage, i, size - 1 - i); //сдвиг массива
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("There is no such resume with ID " + uuid);
        }
    }

    private int findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }
}


