package com.airline.service;

public class ResourceAlreadyExistException extends RuntimeException {
    public ResourceAlreadyExistException(String msg) {
    	super(msg);
    }
}
