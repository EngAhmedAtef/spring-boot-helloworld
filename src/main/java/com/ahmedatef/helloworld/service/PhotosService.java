package com.ahmedatef.helloworld.service;

import com.ahmedatef.helloworld.model.Photo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public Photo getPhoto(String id) {
        Photo photo = db.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't find a photo with the id " + id);
        return photo;
    }

    public void deletePhoto(String id) {
        Photo photo = db.remove(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't find a photo with the id" + id);
    }

    public void addPhoto(Photo photo) {
        photo.setId(UUID.randomUUID().toString());
        db.put(photo.getId(), photo);
    }
}
