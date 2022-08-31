package com.devmountain.NoteApp.services;

import com.devmountain.NoteApp.dtos.NoteDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface NoteService {
    @Transactional
    void addNote(NoteDto noteDto, long id);

    @Transactional
    void deleteNoteById(Long id);

    @Transactional
    void updateNoteById(NoteDto noteDto);

    List<NoteDto> getAllNoteByUserId(Long id);

    Optional<NoteDto> getNoteById(Long id);
}
