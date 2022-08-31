package com.devmountain.NoteApp.repositories;

import com.devmountain.NoteApp.entities.Note;
import com.devmountain.NoteApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {


    List<Note> findAllByUserEquals(User user);
}
