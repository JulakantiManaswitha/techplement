package org.techplement.user;

public class GetResponse extends Response {

    private final User user;

    public GetResponse(int statusCode, String message, User user) {
        super(statusCode, message);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
