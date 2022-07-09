package com.urise.webapp.storage;

import com.urise.webapp.exeption.*;
import com.urise.webapp.model.Resume;
import org.junit.*;


import static org.junit.Assert.*;


public abstract class AbstractArrayStorageTest {
    private Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final Resume r1 = new Resume(UUID_1);

    private static final String UUID_2 = "uuid2";
    private static final Resume r2 = new Resume(UUID_2);

    private static final String UUID_3 = "uuid3";
    private static final Resume r3 = new Resume(UUID_3);

    private static final String UUID_4 = "uuid4";
    private static final Resume r4 = new Resume(UUID_4);

    protected AbstractArrayStorageTest(Storage storage) {
        this.storage = new ArrayStorage();
    }

    @Before
    public void setUp() throws Exception {
        storage = new ArrayStorage();
        storage.clear();
        storage.save(r1);
        storage.save(r2);
        storage.save(r3);
    }

    @Test
    public void size() throws Exception {
        assertEquals(3, storage.size());
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        storage.update(r4);
    }

    @Test
    public void update() throws Exception {
        Resume testResume = new Resume("uuid1");
        storage.update(testResume);
        assertSame(testResume, storage.get("uuid1"));
    }

    @Test
    public void getAll() throws Exception {
        Resume[] test = storage.getAll();
        assertArrayEquals(test, storage.getAll());
    }


    @Test
    public void save() throws Exception {
        storage.save(r4);
        assertEquals(4, storage.size());
    }

    @Test
    public void saveOverFlow() throws Exception {
        for (int i = 0; i < 10000; i++) {
            if (storage.size() >= 10000) {
                fail("The overflow occurred prematurely");
            }
            storage.save(new Resume());
        }
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() throws Exception {
        storage.save(r1);
    }

    @Test
    public void delete() throws Exception {
        storage.delete(r1.getUuid());
        assertEquals(2, storage.size());
    }

    @Test
    public void get() throws Exception {
        Resume testResume = storage.get(r1.getUuid());
        assertSame(testResume, storage.get(r1.getUuid()));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }
}