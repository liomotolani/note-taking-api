package com.shecodeafrica.notetakerapi.dto.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shecodeafrica.notetakerapi.dto.Status;
import com.shecodeafrica.notetakerapi.model.Note;

public class NoteResponseDTO extends StandardResponseDTO{
    @JsonProperty
    private Note note;

    public NoteResponseDTO(){

    }

    public NoteResponseDTO(Status status, Note note){
        super(status);
        this.note = note;
    }

    public NoteResponseDTO(Status status){
        super(status);
    }
}
