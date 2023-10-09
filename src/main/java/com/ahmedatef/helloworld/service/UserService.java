package com.ahmedatef.helloworld.service;

import com.ahmedatef.helloworld.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {

    private final Map<String, User> db = new HashMap<>();

    public Collection<User> getUsers() { return db.values(); }

    public ResponseEntity<?> getUser(String id) {
        User user = db.get(id);
        if (user == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Couldn't find a user with id " + id);
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<Collection<User>> addUser(User user) {
        user.setId(UUID.randomUUID().toString());
        db.put(user.getId(), user);
        return ResponseEntity.ok(db.values());
    }

    public ResponseEntity<?> updateUser(User user) {
        if(!db.containsKey(user.getId()))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Couldn't find a user with id " + user.getId());
        db.put(user.getId(), user);
        return ResponseEntity.ok(db.values());
    }

    public ResponseEntity<?> removeUser(String id) {
        if (!db.containsKey(id))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Couldn't find a user with id " + id);
        db.remove(id);
        return ResponseEntity.ok(db.values());
    }
}
