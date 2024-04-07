package org.techplement.user;

public class UserCreationException extends RuntimeException {
    public UserCreationException(String errorMessage) {
        super(errorMessage);
    }
}
