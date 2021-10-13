package com.note.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.note.restful.model.Note;

//Access Note data
@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
