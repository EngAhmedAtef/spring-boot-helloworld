package com.ahmedatef.helloworld.web;

import com.ahmedatef.helloworld.model.Photo;
import com.ahmedatef.helloworld.service.PhotosService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

@RestController
public class PhotosController {

    private final PhotosService photosService;

    public PhotosController(PhotosService photosService) {
        this.photosService = photosService;
    }

    @GetMapping("/photos")
    public Collection<Photo> getPhotos() {
        return photosService.getPhotos();
    }

    @GetMapping("/photos/{id}")
    public Photo getPhoto(@PathVariable String id) {
        return photosService.getPhoto(id);
    }

    @DeleteMapping("/photos/{id}")
    public Collection<Photo> deletePhoto(@PathVariable String id) {
        photosService.deletePhoto(id);
        return photosService.getPhotos();
    }

//    @PostMapping("/photos")
//    public Photo addPhoto(@RequestBody @Valid Photo photo) {
//        photosService.addPhoto(photo);
//        return photo;
//    }

    @PostMapping("/photos")
    public Photo addPhoto(@RequestPart("data") MultipartFile file) throws IOException {
        Photo photo = new Photo(UUID.randomUUID().toString(), file.getOriginalFilename(), file.getBytes(), file.getContentType());
        photosService.addPhoto(photo);
        return photo;
    }

}
