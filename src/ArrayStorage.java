import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, null); //
    }


    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r; // Вставляем пришедшее нам резюме в первую пустую ячейку.
                return;
            }
        }
    }

    Resume get(String uuid) {

        for (Resume resume : storage) {
            if (resume == null) {
                System.out.println("No resume with such id");
                break;
            } else {
                if (uuid.equals(resume.uuid))
                    return resume;
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
                    break;
                }
            }

        }

        //Двигаем наши резюме налево, чтобы между ними не было пустых ячеек.
        for (int i = 0; i < storage.length - 1; i++) {
            if (storage[i] == null) {
                Resume a = storage[i];
                storage[i] = storage[i + 1];
                storage[i + 1] = a;

            }
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
        int counter = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                counter++;
            } else if (i > counter + 1) { // Так как наши резюме хранятся без пустот между друг другом, нам не нужно
                //перебирать весь массив, чтобы узнать его размер.
                break;
            }
        }

        return counter;
    }
}
