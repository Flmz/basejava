package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {


    @Override
    public abstract void clearStorage();

    @Override
    public abstract void update(Resume r);

    @Override
    public abstract void save(Resume r);

    @Override
    public abstract Resume get(String uuid);

    public abstract void delete(String uuid);

    @Override
    public abstract Resume[] getAll();

    public boolean checkNotExist(Resume r) {
        int index = findIndex(r.getUuid());
        if (index < 0) {
            return false;
        }
        return true;
    }

    public boolean saveExist(Resume r) {
        int index = findIndex(r.getUuid());
        if (index >= 0) {
            return false;
        }
        return true;
    }


    protected abstract int findIndex(String uuid);

}
