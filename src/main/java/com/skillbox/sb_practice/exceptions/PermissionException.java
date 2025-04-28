package com.skillbox.sb_practice.exceptions;

public class PermissionException extends RuntimeException {
    public PermissionException(String message) {
        super(message);
    }

    public PermissionException() {
        super();
    }
}
