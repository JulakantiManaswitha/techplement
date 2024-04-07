package org.techplement.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UserDatabase {

    // UserId - User
    private final Map<String, User> users;

    public UserDatabase() {
        this.users = new HashMap<>();
    }

    public void create(User user) throws UserCreationException {
        if (users.containsKey(user.getUserId())) {
            throw new UserCreationException("User Already Exists");
        } else {
            this.users.put(user.getUserId(), user);
        }
        // INSERT INTO users (userId,email)
        // VALUES
    }

    public void delete(String userId) throws UserNotFoundException {
        if (users.containsKey(userId)) {
            users.remove(userId);
        } else {
            throw new UserNotFoundException("User " + userId + " not found.");
        }
        // DELETE from users WHERE userId=userId
    }

    public void replace(User user) throws UserNotFoundException {
        String userId = user.getUserId();
        if (users.containsKey(userId)) {
            users.put(userId, user);
        } else {
            throw new UserNotFoundException("User " + userId + " not found.");
        }
        // UPDATE users SET userId=userId, where userId=userId
    }

    public User read(String userId) throws UserNotFoundException {
        if (users.containsKey(userId)) {
            return users.get(userId);
        } else {
            throw new UserNotFoundException("User " + userId + " not found.");
        }
        // SELECT * from users where userId=userId
    }
}
