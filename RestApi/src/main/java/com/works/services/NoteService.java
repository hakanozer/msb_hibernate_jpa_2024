package com.works.services;

import com.works.entities.Note;
import com.works.repositories.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class NoteService {

    final NoteRepository noteRepository;

    public ResponseEntity save(Note note) {
        try {
            noteRepository.save(note);
            return new ResponseEntity(note, HttpStatus.OK);
        }catch (Exception ex) {
        }
        String message = "fail title in use :" + note.getTitle();
        Map<String, Object> hm = new HashMap<>();
        hm.put("status", false);
        hm.put("message", message);
        return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
    }

}
