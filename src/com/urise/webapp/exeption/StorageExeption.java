package com.urise.webapp.exeption;

public class StorageExeption extends RuntimeException{
    private final String uuid;

    public StorageExeption(String uuid){
        this.uuid = uuid;
    }

    public StorageExeption(String message, String uuid) {
        super(message);
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }
}
