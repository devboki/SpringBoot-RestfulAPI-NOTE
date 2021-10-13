package com.note.restful.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.note.restful.exception.ResourceNotFoundException;
import com.note.restful.model.Note;
import com.note.restful.repository.NoteRepository;

@RestController
@RequestMapping("/api")
public class NoteController {

	@Autowired
	NoteRepository noteRepository;
	
	//get all notes
	//@RequestMapping(value="/notes", method=RequestMethod.GET)
	@GetMapping("notes")
	public List<Note> getAllNotes(){
		return noteRepository.findAll();
	}
	
	//create a new note
	//@RequestMapping(value="/notes", method=RequestMethod.POST)
	@PostMapping("notes")
	public Note createNote(@Valid @RequestBody Note note) {
		return noteRepository.save(note);
	}
	
	//get a single note
	@GetMapping("/notes/{id}")
	public Note getNoteById(@PathVariable(value="id") Long noteId) {
		return noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
	}
	
	//update a note
	@PutMapping("/notes/{id}")
	public Note updateNote(@PathVariable(value="id") Long noteId, @Valid @RequestBody Note noteDatails) {
		Note note = noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note","id", noteId));
		
		note.setTitle(noteDatails.getTitle());
		note.setContent(noteDatails.getContent());
		
		Note updateNote = noteRepository.save(note);
		return updateNote;
	}
	
	//delete a note
	@DeleteMapping("/notes/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value="id") Long noteId){
		Note note = noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note","id", noteId));
		
		noteRepository.delete(note);
		return ResponseEntity.ok().build();
	}
}
