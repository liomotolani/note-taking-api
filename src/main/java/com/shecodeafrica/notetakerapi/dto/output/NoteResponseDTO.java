package com.shecodeafrica.notetakerapi.dto.output;

import com.shecodeafrica.notetakerapi.dto.Status;
import com.shecodeafrica.notetakerapi.model.Note;

public class NoteResponseDTO extends StandardResponseDTO{
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
