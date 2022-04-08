package com.shecodeafrica.notetakerapi.dto.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateNoteInputDto {

    private String title;

    private String content;

}
