package com.ahmedatef.helloworld.web;

import com.ahmedatef.helloworld.model.Photo;
import com.ahmedatef.helloworld.service.PhotosService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DownloadController {

    private final PhotosService photosService;

    public DownloadController(PhotosService photosService) {
        this.photosService = photosService;
    }

    @GetMapping("/photos/download/{id}")
    public ResponseEntity<?> downloadPhoto(@PathVariable String id) {
        ResponseEntity<?> photoResponse = photosService.getPhoto(id);
        if(photoResponse.getStatusCode() != HttpStatus.OK)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Couldn't find a photo with the id " + id);
        Photo photo = (Photo) photoResponse.getBody();
        byte[] data = photo.getData();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(photo.getContentType()));
        ContentDisposition contentDisposition = ContentDisposition
                .builder("inline")
                .filename(photo.getFileName())
                .build();
        headers.setContentDisposition(contentDisposition);
        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }

}
