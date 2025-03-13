package com.github.Mazlik9.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.Mazlik9.model.Note;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {

    private static final String FILE_PATH = "notes.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    // Получение всех заметок
    public List<Note> getNotes() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            return objectMapper.readValue(file, new TypeReference<List<Note>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Добавление заметки
    public void addNote(Note note) {
        List<Note> notes = getNotes();
        notes.add(note);
        saveNotes(notes);
    }

    // Сохранение заметок в файл
    private void saveNotes(List<Note> notes) {
        try {
            objectMapper.writeValue(new File(FILE_PATH), notes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Удаление заметки
    public void deleteNote(int index) {
        List<Note> notes = getNotes();
        if (index >= 0 && index < notes.size()) {
            notes.remove(index);
            saveNotes(notes);
        }
    }

    // Обновление заметки
    public void updateNote(int index, Note updatedNote) {
        List<Note> notes = getNotes();
        if (index >= 0 && index < notes.size()) {
            notes.set(index, updatedNote);
            saveNotes(notes);
        }
    }
}