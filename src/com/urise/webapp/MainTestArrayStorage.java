package com.urise.webapp;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.ArrayStorage;
import com.urise.webapp.storage.ListStorage;
import com.urise.webapp.storage.SortedArrayStorage;

/**
 * Test for your ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();
    static final SortedArrayStorage SORTED_ARRAY_STORAGE = new SortedArrayStorage();
    static final ListStorage LIST_STORAGE = new ListStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume("uuid1");

        Resume r2 = new Resume("uuid2");

        Resume r3 = new Resume("uuid3");

        LIST_STORAGE.save(r1);
        LIST_STORAGE.save(r2);
        LIST_STORAGE.save(r3);

        System.out.println(LIST_STORAGE.getSize());

        LIST_STORAGE.delete("uuid2");

        System.out.println(LIST_STORAGE.getSize());

        printAllListStorage();





//        ARRAY_STORAGE.save(r1);
//        ARRAY_STORAGE.save(r2);
//        ARRAY_STORAGE.save(r3);
//
//        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
//        System.out.println("Size: " + ARRAY_STORAGE.getSize());
//
//        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));
//
//        printAllStorage();
//        ARRAY_STORAGE.delete(r1.getUuid());
//        printAllSortedStorage();
//        ARRAY_STORAGE.clearStorage();
//
//        System.out.println("Size: " + ARRAY_STORAGE.getSize());
//
//        ARRAY_STORAGE.update(r2);
//
//        SORTED_ARRAY_STORAGE.save(r1);
//        SORTED_ARRAY_STORAGE.save(r3);
//        SORTED_ARRAY_STORAGE.save(r2);
//
//        printAllSortedStorage();
//
//        System.out.println();
    }

    static void printAllStorage() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
    static void printAllSortedStorage() {
        System.out.println("\nGet All");
        for (Resume r : SORTED_ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
    static void printAllListStorage(){
        System.out.println("\nGet All");
        for(Resume r: LIST_STORAGE.getAll()){
            System.out.println(r);
        }
    }
}
