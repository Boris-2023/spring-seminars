package ru.gb.hw06.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.hw06.domain.Note;
import ru.gb.hw06.repository.NoteRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NoteController {
    private final NoteRepository repository;

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        return new ResponseEntity<>(repository.save(note), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        Optional<Note> noteOpt = repository.findById(id);
        if (noteOpt.isPresent()) {
            return new ResponseEntity<>(noteOpt.get(), HttpStatus.FOUND);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNoteById(@PathVariable Long id, @RequestBody Note note) {
        Optional<Note> noteOpt = repository.findById(id);
        try {
            Note noteFound = noteOpt.get();

            noteFound.setTitle(note.getTitle());
            noteFound.setText(note.getText());

            return new ResponseEntity<>(repository.save(noteFound), HttpStatus.OK);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotById(@PathVariable Long id) {
        Optional<Note> noteOpt = repository.findById(id);
        if (noteOpt.isPresent()) {
            repository.delete(noteOpt.get());
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
