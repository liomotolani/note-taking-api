package com.shecodeafrica.notetakerapi.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String title;
    private String content;
    @Column(name = "created_date", columnDefinition="DATE")
    private Date createdDate;

    @Column(name = "updated_date", columnDefinition="DATE")
    private Date updatedDate;
}
