package com.urise.webapp.exeption;

public class ExistStorageException extends StorageExeption {

    public ExistStorageException(String uuid) {
        super("Resume already exist", uuid);
    }
}
