package com.example.diplom.repository;

import com.example.diplom.model.NoteDiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteDiaryRepository extends JpaRepository<NoteDiary, Long> {

}
