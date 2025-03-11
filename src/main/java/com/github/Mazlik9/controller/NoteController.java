package com.github.Mazlik9.controller;

import com.github.Mazlik9.model.Note;
import com.github.Mazlik9.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    // get all notes
    @GetMapping
    public Page<Note> getAllNotes(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size) {
        return noteService.getAllNotes(PageRequest.of(page, size));
    }

    // create note
    @PostMapping
    public Note createNote(@Valid @RequestBody Note note) {
        return noteService.createNote(note);
    }

    // get note on ID
    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable Long id) {
        return noteService.getNoteById(id);
    }

    // update note
    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id, @Valid @RequestBody Note updatedNote) {
        return noteService.updateNote(id, updatedNote);
    }

    // delete note
    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }

    // search notes
    @GetMapping("/search")
    public Page<Note> searchNotes(@RequestParam String keyword,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size) {
        return noteService.searchNotes(keyword, PageRequest.of(page, size));
    }
}