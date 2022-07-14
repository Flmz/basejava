package com.urise.webapp.storage;

import com.urise.webapp.exception.*;
import com.urise.webapp.model.Resume;
import org.junit.*;


import static com.urise.webapp.storage.AbstractArrayStorage.STORAGE_LIMIT;
import static org.junit.Assert.*;


public abstract class AbstractArrayStorageTest {
    private final Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final String UUID_NOT_EXIST = "dummy";

    private static final Resume RESUME_1;
    private static final Resume RESUME_2;
    private static final Resume RESUME_3;
    private static final Resume RESUME_4;

    static {
        RESUME_1 = new Resume(UUID_1);
        RESUME_2 = new Resume(UUID_2);
        RESUME_3 = new Resume(UUID_3);
        RESUME_4 = new Resume(UUID_4);
    }


    protected AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clearStorage();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void size() throws Exception {
        assertSize(3);
    }

    @Test
    public void clear() throws Exception {
        storage.clearStorage();
        assertSize(0);
        assertArrayEquals(new Resume[0], storage.getAll());
    }

    @Test
    public void update() throws Exception {
        Resume testResume = new Resume(UUID_1);
        storage.update(testResume);
        assertSame(testResume, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        storage.update(RESUME_4);
    }

    @Test
    public void getAll() throws Exception {
        final Resume[] EXPECTED_RESUMES = {RESUME_1, RESUME_2, RESUME_3};
        Resume[] testResume = storage.getAll();
        assertArrayEquals(EXPECTED_RESUMES, testResume);
        assertSize(3);
    }

    @Test
    public void save() throws Exception {
        storage.save(RESUME_4);
        assertSize(4);
        assertGet(RESUME_4);
    }

    @Test(expected = StorageExeption.class)
    public void saveOverFlow() throws Exception {
        storage.clearStorage();
        try {
            for (int i = 0; i < STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        } catch (StorageExeption ex) {
            fail("The overflow occurred prematurely");
        }
        storage.save(RESUME_1);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() throws Exception {
        storage.save(RESUME_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(RESUME_1.getUuid());
        assertSize(2);
        storage.get(RESUME_1.getUuid());
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete(UUID_NOT_EXIST);
    }

    @Test
    public void get() throws Exception {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get(UUID_NOT_EXIST);
    }

    public void assertSize(int size) {
        assertEquals(size, storage.getSize());
    }

    public void assertGet(Resume r) throws Exception {
        Resume testResume = storage.get(r.getUuid());
        assertEquals(testResume, storage.get(r.getUuid()));
    }
}

