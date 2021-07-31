package com.example.springboot.exception;

public class RoomException extends RuntimeException {
    public RoomException() {
        super();
    }

    public RoomException(String message) {
        super(message);
    }
}
