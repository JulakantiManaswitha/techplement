package org.techplement.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final UserService service;

    public Controller(final UserService userService) {
        this.service = userService;
    }

    // POST {URI}/user
    @PostMapping("/user")
    public ResponseEntity<Response> create(@RequestBody User user) {
        Response response = service.create(user);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    // GET {URI}/user/123412
    @GetMapping("/user/{userId}")
    public ResponseEntity<Response> readWithPathParam(@PathVariable String userId) {
        Response response = service.read(userId);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    // PUT {URI}/user
    @PutMapping("/user")
    public ResponseEntity<Response> replace(@RequestBody User user) {
        Response response = service.replace(user);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    // DELETE {URI}/user/123412
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Response> deleteWithPathParam(@PathVariable String userId) {
        Response response = service.delete(userId);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

}
