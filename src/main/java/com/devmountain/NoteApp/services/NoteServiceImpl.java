package com.devmountain.NoteApp.services;

import com.devmountain.NoteApp.dtos.NoteDto;
import com.devmountain.NoteApp.entities.Note;
import com.devmountain.NoteApp.entities.User;
import com.devmountain.NoteApp.repositories.NoteRepository;
import com.devmountain.NoteApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NoteRepository noteRepository;

    @Override
    @Transactional
    public void addNote(NoteDto noteDto, long id)
    {
        Optional<User> userOptional = userRepository.findById(id);
        Note note = new Note(noteDto);
        userOptional.ifPresent(note::setUser);
        noteRepository.saveAndFlush(note);
    }

    @Override
    @Transactional
    public void deleteNoteById(Long id)
    {
        Optional<Note> noteOptional = noteRepository.findById(id);
        noteOptional.ifPresent(note -> noteRepository.delete(note));
    }

    @Override
    @Transactional
    public void updateNoteById(NoteDto noteDto)
    {
        Optional<Note>  noteOptional = noteRepository.findById(noteDto.getId());
        noteOptional.ifPresent(note -> {
            note.setBody(noteDto.getBody());
            noteRepository.saveAndFlush(note);
        });
    }

    @Override
    public List<NoteDto> getAllNoteByUserId(Long id)
    {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent())
        {
            List<Note> noteList = noteRepository.findAllByUserEquals(userOptional.get());
            return noteList.stream().map(note -> new NoteDto(note)).collect(Collectors.toList());
        }

        return Collections.emptyList();
    }

    @Override
    public Optional<NoteDto> getNoteById(Long id)
    {
        Optional<Note> noteOptional = noteRepository.findById(id);

        if(noteOptional.isPresent())
        {
            return Optional.of(new NoteDto(noteOptional.get()));
        }

        return Optional.empty();
    }



}
