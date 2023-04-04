package com.shivaot.hotelservice.exceptions;

/**
 * Shiva Created on 02/04/23
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("Resource not found on server");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
