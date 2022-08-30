package com.devmountain.NoteApp.dtos;


import com.devmountain.NoteApp.entities.Note;
import com.devmountain.NoteApp.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteDto implements Serializable {
    private Long id;

    private String body;

    private User user;

    public NoteDto(Note note) {

        if(note.getId() != null)
            this.id = note.getId();

        if(note.getBody() != null)
            this.body = note.getBody();

        if(note.getUser() != null)
            this.user = note.getUser();

    }
}
