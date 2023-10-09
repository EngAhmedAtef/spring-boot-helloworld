package com.ahmedatef.helloworld.service;

import com.ahmedatef.helloworld.model.Photo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PhotosService {

    private Map<String, Photo> db = new HashMap<>();

    public Collection<Photo> getPhotos() {
        return db.values();
    }

    public ResponseEntity<?> getPhoto(String id) {
        Photo photo = db.get(id);
        if (photo == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Couldn't find a photo with the id " + id);
        return ResponseEntity.ok(photo);
    }

    public ResponseEntity<?> deletePhoto(String id) {
        Photo photo = db.remove(id);
        if (photo == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Couldn't find a photo with the id" + id);
        return ResponseEntity.ok(db.values());
    }

    public void addPhoto(Photo photo) {
        photo.setId(UUID.randomUUID().toString());
        db.put(photo.getId(), photo);
    }
}
