package com.github.Mazlik9.repository;

import com.github.Mazlik9.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
