package com.urise.webapp.exeption;

public class NotExistStorageException extends StorageExeption{

    public NotExistStorageException(String uuid) {
        super("Resume not exist",uuid);
    }
}
