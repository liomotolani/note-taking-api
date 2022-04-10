package com.shecodeafrica.notetakerapi.service;

import com.shecodeafrica.notetakerapi.dto.Status;
import com.shecodeafrica.notetakerapi.dto.input.CreateNoteInputDto;
import com.shecodeafrica.notetakerapi.dto.input.UpdateNoteInputDto;
import com.shecodeafrica.notetakerapi.dto.output.NoteListResponseDTO;
import com.shecodeafrica.notetakerapi.dto.output.NoteResponseDTO;
import lombok.RequiredArgsConstructor;
import com.shecodeafrica.notetakerapi.model.Note;
import org.springframework.stereotype.Service;
import com.shecodeafrica.notetakerapi.repository.NoteRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteResponseDTO createNote(CreateNoteInputDto dto){
        Note note = new Note();
        note.setTitle(dto.getTitle());
        note.setContent(dto.getContent());
        note.setCreatedDate(new Date());
        noteRepository.save(note);
        return new NoteResponseDTO(Status.CREATED, note);
    }

    public NoteResponseDTO updateNote(UpdateNoteInputDto dto, int id) {
        Note note = noteRepository.findById(id).get();

        if(!noteRepository.existsById(id)){
            return new NoteResponseDTO(Status.NOT_FOUND);
        }
        if(dto.getTitle() == null && dto.getContent() == null){
            return new NoteResponseDTO(Status.SUCCESS, note);
        }
        if(dto.getTitle() == null){
            note.setContent(dto.getContent());
            note.setUpdatedDate(new Date());
            noteRepository.save(note);
            return new NoteResponseDTO(Status.SUCCESS, note);
        }
        if(dto.getContent() == null){
            note.setTitle(dto.getTitle());
            note.setUpdatedDate(new Date());
            noteRepository.save(note);
            return new NoteResponseDTO(Status.SUCCESS,note);
        }
        note.setTitle(dto.getTitle());
        note.setContent(dto.getContent());
        note.setUpdatedDate(new Date());
        noteRepository.save(note);
        return new NoteResponseDTO(Status.SUCCESS,note);
    }

    public NoteResponseDTO deleteNoteById(int id){
        if(!noteRepository.existsById(id)){
            return new NoteResponseDTO(Status.NOT_FOUND);
        }
        noteRepository.deleteById(id);
        return new NoteResponseDTO(Status.NO_CONTENT);
    }

    public NoteResponseDTO deleteNoteByTitle(String title){
        Optional<Note> note = noteRepository.findByTitle(title);
        if(!note.isPresent()){
            return new NoteResponseDTO(Status.NOT_FOUND);
        }
        noteRepository.deleteByTitle(title);
        return new NoteResponseDTO(Status.NO_CONTENT);
    }

    public NoteResponseDTO findNoteById(int id){
        Note note = noteRepository.getById(id);
        if(!noteRepository.existsById(id)){
            return new NoteResponseDTO(Status.NOT_FOUND);
        }
        return new NoteResponseDTO(Status.SUCCESS, note);
    }

    public NoteResponseDTO findNoteByTitle(String title){
        Optional<Note> note = noteRepository.findByTitle(title);
        if(!note.isPresent()){
            return new NoteResponseDTO(Status.NOT_FOUND);
        }
        return new NoteResponseDTO(Status.SUCCESS, note.get());
    }

    public NoteListResponseDTO fetchAllNotes(){
        List<Note> notes = noteRepository.findAll();
        if(notes.isEmpty()){
            return new NoteListResponseDTO(Status.NOT_FOUND);
        }
        return new NoteListResponseDTO(Status.SUCCESS, notes);
    }
}
