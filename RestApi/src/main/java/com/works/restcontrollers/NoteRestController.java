package com.works.restcontrollers;

import com.works.entities.Note;
import com.works.services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("note")
public class NoteRestController {

    final NoteService noteService;

    @PostMapping("save")
    public ResponseEntity save(@RequestBody Note note) {
        return noteService.save(note);
    }

}
