import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;

    }

    void save(Resume r) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(r.uuid)) {
                System.out.println("Resume " + r.uuid + " is already on the storage");
                return;
            }
        }

        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid))
                return storage[i];
        }
        System.out.println("No resume with such id");
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                storage[i] = null;
                System.arraycopy(storage, i + 1, storage, i, size);//двигаем массив, чтобы не было пустот ме
                //между резюме
                size--;
                break;
            }
        }
    }

    Resume[] getAll() {
        Resume[] copyResume;
        copyResume = Arrays.copyOf(storage, size);
        return copyResume;
    }

    int size() {
        return size;
    }
}


