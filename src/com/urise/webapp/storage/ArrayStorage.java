package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;

    }
    void update(Resume r, String uuid){
        for(int i =0; i < size; i++){
            if(isResumeInStorage(r,i)){
                storage[i].uuid = uuid;
                return;
            }
        }
        System.out.println("There is no such resume with ID " + uuid);
    }

    public void save(Resume r) {
        for (int i = 0; i < size; i++) {
            if (isResumeInStorage(r, i)) {
                System.out.println("Resume " + r.uuid + " is already on the storage");
                return;
            }
        }
        storage[size] = r;
        size++;
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (isResumeInStorage(uuid, i))
                return storage[i];
        }
        System.out.println("There is no such resume with ID " + uuid);
        return null;
    }

    //двигаем массив, чтобы не было пустот ме
    //между резюме
    public void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (isResumeInStorage(uuid, i)) {
                System.arraycopy(storage, i + 1, storage, i, size - 1 - i);
                storage[size - 1] = null;
                size--;
                return;
            }
        }
        System.out.println("There is no such resume with ID " + uuid);
    }

    private boolean isResumeInStorage(String uuid, int index) {
        return uuid.equals(storage[index].uuid);
    }
    //Этими методами попытался избавиться от дублирования кода.
    private boolean isResumeInStorage(Resume r, int index) {
        return storage[index].uuid.equals(r.uuid);
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }
}


