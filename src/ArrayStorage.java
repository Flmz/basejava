import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && storage[i].uuid.equals(r.uuid)) {
                System.out.println("This resume is already on the storage");
                return;
            }
        }
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r; // Вставляем пришедшее нам резюме в первую пустую ячейку.
                size++;
                return;
            }
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                System.out.println("No resume with such id");
                break;
            } else {
                if (uuid.equals(storage[i].uuid))
                    return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) { //тут проверяем ячейку массива на null, чтобы не было NullPointerException
                break;
            } else {
                if (uuid.equals(storage[i].uuid)) {
                    storage[i] = null;
                    System.arraycopy(storage, i + 1, storage, i, storage.length - 1 - i);//сдвигаем наш массив,
                    //чтобы не было пустых ячеек между id
                    size--;
                    break;
                }
            }
        }
    }

    void print() {
        for (int i = 0; i < storage.length - 1; i++) {
            System.out.println(storage[i]);
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    Resume[] getAll() {
        Resume[] copyResume = new Resume[size()];

        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                copyResume[i] = storage[i];
            } else {
                break;
            }
        }
        //возвращаем новый массив, который имеет размер в кол-ве наших резюме. Без null;
        return copyResume;
    }

    int size() {
        return size;
    }
}
