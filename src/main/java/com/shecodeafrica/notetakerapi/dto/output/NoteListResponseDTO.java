package com.shecodeafrica.notetakerapi.dto.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shecodeafrica.notetakerapi.dto.Status;
import com.shecodeafrica.notetakerapi.model.Note;

import java.util.List;

public class NoteListResponseDTO extends StandardResponseDTO{

    @JsonProperty
    private List<Note> note;


    public NoteListResponseDTO(){

    }

    public NoteListResponseDTO(Status status, List<Note> note){
        super(status);
        this.note = note;
    }

    public NoteListResponseDTO(Status status){
        super(status);
    }
}
