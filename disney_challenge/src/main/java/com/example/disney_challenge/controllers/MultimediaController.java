package com.example.disney_challenge.controllers;

import com.example.disney_challenge.dtos.MultimediaDTO;
import com.example.disney_challenge.models.MultimediaEntity;
import com.example.disney_challenge.services.MultimediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class MultimediaController {

    @Autowired
    MultimediaService multimediaService;

    @PostMapping("/multimedia/save")
    public ResponseEntity<MultimediaEntity> save(@RequestBody MultimediaEntity multimediaEntity) {
        MultimediaEntity multimediaEntity1 = multimediaService.create(multimediaEntity);

        try {
            return ResponseEntity.created(new URI("/multimedia" + multimediaEntity1.getId())).body(multimediaEntity1);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/multimedia/details")
    public ResponseEntity<List<MultimediaEntity>> multimediaDetails() {
        var multimedia = multimediaService.multimediaDetails();
        return new ResponseEntity(multimedia, HttpStatus.OK);
    }

    @GetMapping("/multimedia")
    public ResponseEntity<List<Object>> getMultimedia(@RequestParam(required = false) String title,
                                                      @RequestParam(required = false) String genre) {
        List multimediaList = null;
        if (title != null || genre != null) {
            multimediaList = multimediaService.findByFilters(title, genre);
        } else {
            var multimedia = multimediaService.getMultimedia();
            if (multimedia == null) {
                return new ResponseEntity(new ArrayList<>(), HttpStatus.NOT_FOUND);
            }
            multimediaList = multimedia;
        }
        return ResponseEntity.ok(multimediaList);
    }

    @DeleteMapping("/multimedia/delete/id")
    public String deleteMultimedia(@PathVariable("id") Long id) {
        multimediaService.deleteMultimedia(id);
        return "Delete successfully id =" + id;
    }

    @GetMapping(value = "/multimedia/{id}")
    public ResponseEntity<MultimediaDTO> listById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(multimediaService.findById(id));
    }

    @PutMapping(value = "/multimedia/{id}")
    public ResponseEntity<MultimediaEntity> updateMultimedia(@PathVariable("id") Long id, @RequestBody MultimediaEntity multimediaEntity) {
        return ResponseEntity.ok(multimediaService.updateMultimedia(id, multimediaEntity));
    }


}
