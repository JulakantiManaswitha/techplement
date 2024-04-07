package org.techplement.user;

import java.util.Objects;

public class User {
    private final String userId;
    private final String emailId;
    private final String name;
    private final String dateOfBirth;
    private final String password;

    public User(String userId, String emailId, String name, String dateOfBirth, String password) {
        this.userId = userId;
        this.emailId = emailId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(getUserId(), user.getUserId()) && Objects.equals(getEmailId(), user.getEmailId()) && Objects.equals(getName(), user.getName()) &&
               Objects.equals(getDateOfBirth(), user.getDateOfBirth()) && Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getEmailId(), getName(), getDateOfBirth(), getPassword());
    }

    @Override
    public String toString() {
        return "User{"
               + "userId='" + userId + '\''
               + ", emailId='" + emailId + '\''
               + ", name='" + name + '\''
               + ", dateOfBirth='" + dateOfBirth + '\''
               + ", password='" + password + '\''
               + '}';
    }
}
