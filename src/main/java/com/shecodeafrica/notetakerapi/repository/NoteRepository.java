package com.shecodeafrica.notetakerapi.repository;

import com.shecodeafrica.notetakerapi.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Integer> {
    Optional<Note> findByTitle(String title);
    void deleteByTitle(String title);
}
