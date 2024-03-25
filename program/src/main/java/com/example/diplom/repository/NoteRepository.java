package com.example.diplom.repository;


import com.example.diplom.model.Note;
import com.example.diplom.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    Optional<Note> findById(Long id);

    List<Note> findByUser(User user);


}