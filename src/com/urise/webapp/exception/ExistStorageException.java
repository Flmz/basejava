package com.urise.webapp.exception;

public class ExistStorageException extends StorageExeption {

    public ExistStorageException(String uuid) {
        super("Resume already exist", uuid);
    }
}
