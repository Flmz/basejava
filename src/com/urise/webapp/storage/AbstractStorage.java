package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {
    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    public void save(Resume r) {
        LOG.info("Save " + r);
        SK searchKey = findExistingKey(r.getUuid());
        doSave(r, searchKey);
    }

    @Override
    public void delete(String uuid) {
        LOG.info("Delete " + uuid);
        SK searchKey = findNotExistingKey(uuid);
        doDelete(searchKey);
    }

    public Resume get(String uuid) {
        LOG.info("Get " + uuid);
        SK searchKey = findNotExistingKey(uuid);
        return doGet(searchKey);
    }

    public void update(Resume r) {
        LOG.info("Update " + r);
        SK searchKey = findNotExistingKey(r.getUuid());
        doUpdate(r, searchKey);
    }

    protected SK findExistingKey(String key) {
        if (isExist(findSearchKey(key))) {
            LOG.warning("Resume already exist: " + key);
            throw new ExistStorageException(key);
        } else {
            return findSearchKey(key);
        }
    }

    protected SK findNotExistingKey(String key) {
        if (isExist(findSearchKey(key))) {
            return findSearchKey(key);
        } else {
            LOG.warning("Resume not exist: " + key);
            throw new NotExistStorageException(key);
        }
    }

    public List<Resume> getAllSorted() {
        LOG.info("getAllSorted");
        List<Resume> list = doCopyAll();
        Collections.sort(list);
        return list;
    }

    public abstract boolean isExist(SK searchKey);

    protected abstract Resume doGet(SK searchKey);

    protected abstract void doDelete(SK searchKey);

    protected abstract void doSave(Resume r, SK searchKey);

    protected abstract void doUpdate(Resume r, SK searchKey);

    protected abstract SK findSearchKey(String uuid);

    public abstract void clear();

    public abstract List<Resume> doCopyAll();

}

