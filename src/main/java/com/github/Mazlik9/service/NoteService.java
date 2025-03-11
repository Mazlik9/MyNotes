package com.github.Mazlik9.service;

import com.github.Mazlik9.model.Note;
import com.github.Mazlik9.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    // get all notes
    public Page<Note> getAllNotes(Pageable pageable) {
        return noteRepository.findAll(pageable);
    }

    // create note
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    // get note on ID
    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElseThrow(() -> new RuntimeException("Заметка не найдена"));
    }

    // update note
    public Note updateNote(Long id, Note updatedNote) {
        Note note = noteRepository.findById(id).orElseThrow(() -> new RuntimeException("Заметка не найдена"));
        note.setTitle(updatedNote.getTitle());
        note.setContent(updatedNote.getContent());
        return noteRepository.save(note);
    }

    // delete note
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

    // search with keywords
    public Page<Note> searchNotes(String keyword, Pageable pageable) {
        return noteRepository.findByTitleContaining(keyword, pageable);
    }
}