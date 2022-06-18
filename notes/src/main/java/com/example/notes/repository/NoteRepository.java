package com.example.notes.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.notes.model.Note;



@Repository
@Transactional
public interface NoteRepository extends JpaRepository<Note, Integer>{

}
