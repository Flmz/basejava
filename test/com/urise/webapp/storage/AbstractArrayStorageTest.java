package com.urise.webapp.storage;


import com.urise.webapp.exception.StorageExeption;
import com.urise.webapp.model.Resume;
import org.junit.Test;

import static com.urise.webapp.storage.AbstractArrayStorage.STORAGE_LIMIT;
import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageExeption.class)
    public void saveOverFlow() throws Exception {
        storage.clear();
        try {
            for (int i = 0; i < STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        } catch (StorageExeption ex) {
            fail("The overflow occurred prematurely");
        }
        storage.save(new Resume());
    }
}
