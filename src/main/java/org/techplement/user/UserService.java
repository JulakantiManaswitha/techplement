package org.techplement.user;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDatabase userDatabase;

    public UserService(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }

    public Response create(User user) {
        try {
            boolean isUserValid = isUserValid(user);
            if (isUserValid) {
                this.userDatabase.create(user);
                return new Response(HttpStatus.OK.value(), "Successfully Created");
            } else {
                return new Response(HttpStatus.BAD_REQUEST.value(), "Invalid Email Id or DOB");
            }
        } catch (UserCreationException exception) {
            return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage());
        }
    }

    // TODO: Complete this
    private boolean isUserValid(User user) {
        String email = user.getEmailId();
        // valid email - @
        String dateOfBirth = user.getDateOfBirth();
        // valid dob - dd/mm/yyyy
        return true;
    }

    public Response replace(User user) {
        try {
            this.userDatabase.replace(user);
            return new Response(HttpStatus.OK.value(), "Success");
        } catch (UserNotFoundException exception) {
            return new Response(HttpStatus.NOT_FOUND.value(), "User Not Found");
        }
    }

    public Response delete(String userId) {
        try {
            this.userDatabase.delete(userId);
            return new Response(HttpStatus.OK.value(), "Success");
        } catch (UserNotFoundException exception) {
            return new Response(HttpStatus.NOT_FOUND.value(), "User Not Found");
        }
    }

    public Response read(String userId) {
        try {
            User user = this.userDatabase.read(userId);
            return new GetResponse(HttpStatus.OK.value(), "Success", user);
        } catch (UserNotFoundException exception) {
            return new Response(HttpStatus.NOT_FOUND.value(), "User Not Found");
        }
    }
}
