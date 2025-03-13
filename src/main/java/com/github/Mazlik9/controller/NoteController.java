package com.github.Mazlik9.controller;

import com.github.Mazlik9.model.Note;
import com.github.Mazlik9.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    /**
     * Отображает список всех заметок.
     *
     * @param model Модель для передачи данных в представление.
     * @return      Имя представления для отображения списка заметок.
     */
    @GetMapping
    public String getNotes(Model model) {
        model.addAttribute("notes", noteService.getNotes());
        model.addAttribute("note", new Note());
        return "notes";
    }

    /**
     * Обрабатывает добавление новой заметки.
     *
     * @param note          Новая заметка для добавления.
     * @param bindingResult Результат проверки данных заметки.
     * @param model         Модель для передачи данных в представление.
     * @return              Перенаправление на страницу со списком заметок или возврат к форме добавления при ошибках.
     */
    @PostMapping
    public String addNote(@Valid @ModelAttribute("note") Note note, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("notes", noteService.getNotes());
            return "notes";
        }
        noteService.addNote(note);
        return "redirect:/notes";
    }

    /**
     * Удаляет заметку по индексу.
     *
     * @param index Индекс заметки для удаления.
     * @return      Перенаправление на страницу со списком заметок.
     */
    @PostMapping("/delete")
    public String deleteNote(@RequestParam int index) {
        noteService.deleteNote(index);
        return "redirect:/notes";
    }

    /**
     * Отображает форму редактирования заметки.
     *
     * @param index Индекс заметки для редактирования.
     * @param model Модель для передачи данных в представление.
     * @return      Имя представления для отображения формы редактирования или перенаправление на список заметок.
     */
    @GetMapping("/edit/{index}")
    public String showEditForm(@PathVariable int index, Model model) {
        List<Note> notes = noteService.getNotes();
        if (index >= 0 && index < notes.size()) {
            model.addAttribute("note", notes.get(index));
            model.addAttribute("index", index);
            return "edit-note";
        }
        return "redirect:/notes";
    }

    /**
     * Обрабатывает обновление заметки.
     *
     * @param index          Индекс заметки для обновления.
     * @param updatedNote    Обновленная заметка.
     * @param bindingResult  Результат проверки данных заметки.
     * @param model          Модель для передачи данных в представление.
     * @return               Перенаправление на страницу со списком заметок или возврат к форме редактирования при ошибках.
     */
    @PostMapping("/edit/{index}")
    public String updateNote(@PathVariable int index, @Valid Note updatedNote, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("note", updatedNote);
            model.addAttribute("index", index);
            return "edit-note";
        }
        noteService.updateNote(index, updatedNote);
        return "redirect:/notes";
    }
}
