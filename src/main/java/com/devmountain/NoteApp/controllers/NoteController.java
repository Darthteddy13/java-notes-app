package com.devmountain.NoteApp.controllers;


import com.devmountain.NoteApp.dtos.NoteDto;
import com.devmountain.NoteApp.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    //Getting notes referring to user id
    @GetMapping("/user/{userId}")
    public List<NoteDto> getNotesByUser(@PathVariable Long id)
    {
        return noteService.getAllNoteByUserId(id);
    }

    //adding new notes
    @PostMapping("user/{userId}")
    public void addNote(@RequestBody NoteDto noteDto, @PathVariable Long id)
    {
        noteService.addNote(noteDto, id);
    }

    //Delete existing note by note id
    @DeleteMapping("/{noteId}")
    public void deleteNoteById(@PathVariable Long id)
    {
        noteService.deleteNoteById(id);
    }

    @PutMapping
    public void updateNote(@RequestBody NoteDto noteDto)
    {
        noteService.updateNoteById(noteDto);
    }

    @GetMapping("/{noteId}")
    public Optional<NoteDto> getNoteById(@PathVariable Long id)
    {
        return noteService.getNoteById(id);
    }



}
