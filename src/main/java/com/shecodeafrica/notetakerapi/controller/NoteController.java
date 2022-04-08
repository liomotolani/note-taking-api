package com.shecodeafrica.notetakerapi.controller;

import com.shecodeafrica.notetakerapi.dto.input.CreateNoteInputDto;
import com.shecodeafrica.notetakerapi.dto.input.UpdateNoteInputDto;
import com.shecodeafrica.notetakerapi.dto.output.NoteListResponseDTO;
import com.shecodeafrica.notetakerapi.dto.output.NoteResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.shecodeafrica.notetakerapi.service.NoteService;

@RestController
@RequestMapping("/v1/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;


    @PostMapping("/create")
    public NoteResponseDTO createNote(@RequestBody CreateNoteInputDto dto){
        return noteService.createNote(dto);
    }

    @PutMapping("/update/{id}")
    public NoteResponseDTO updateNote(@RequestBody UpdateNoteInputDto dto, @PathVariable("id") int id){
        return noteService.updateNote(dto,id);
    }

    @DeleteMapping("/delete/{id}")
    public NoteResponseDTO deleteNoteById(@PathVariable("id") int id){
        return noteService.deleteNoteById(id);
    }

    @DeleteMapping("/delete/{title}")
    public NoteResponseDTO deleteNoteByTitle(@PathVariable("title") String title){
        return noteService.deleteNoteByTitle(title);
    }

    @GetMapping("/note-id/{id}")
    public NoteResponseDTO findNoteById(@PathVariable("id") int id){
        return noteService.findNoteById(id);
    }

    @GetMapping("/note-title/{title}")
    public NoteResponseDTO findNoteByTitle(@PathVariable("title") String title){
        return noteService.findNoteByTitle(title);
    }

    @GetMapping("/all")
    public NoteListResponseDTO findAllNotes(){
        return noteService.fetchAllNotes();
    }
}
