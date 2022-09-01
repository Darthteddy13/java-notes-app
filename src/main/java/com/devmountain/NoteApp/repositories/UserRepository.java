package com.devmountain.NoteApp.repositories;

import com.devmountain.NoteApp.dtos.UserDto;
import com.devmountain.NoteApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByUsername(String username);
}
