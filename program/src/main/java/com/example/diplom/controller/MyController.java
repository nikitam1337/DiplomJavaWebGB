package com.example.diplom.controller;

import com.example.diplom.model.User;
import com.example.diplom.model.Note;
import com.example.diplom.model.NoteDiary;
import com.example.diplom.service.NoteDiaryService;
import com.example.diplom.service.NoteService;
import com.example.diplom.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class MyController {

    private final NoteService noteService;

    private final NoteDiaryService noteDiaryService;

    private UserService userService;

    @GetMapping("/home")
    String home() {
        return "home";
    }

    @GetMapping("/diary")
    public String createDiaryForm(Note note) {
        return "/diary";
    }

    @PostMapping("/storyDiary")
    public String createDiary(Model model, Note note) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(authentication.getName());
        user.addNoteToUser(note);
        noteService.createNote(note);
        List<Note> noteList = noteService.getNotesByUser(user);
        model.addAttribute("notes", noteList);
        return "storyDiary";
    }

    @GetMapping("/storyDiary")
    public String diaryStory(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(authentication.getName());
        List<Note> noteList = noteService.getNotesByUser(user);
        model.addAttribute("notes", noteList);
        return "storyDiary";
    }

    @GetMapping("/directory")
    public String directory(Model model) {
        List<NoteDiary> noteDiaryList = noteDiaryService.listNotesDiary();
        model.addAttribute("notesDiary", noteDiaryList);
        return "directory";
    }

    @GetMapping("note-delete/{id}")
    public String deleteNote(@PathVariable("id") Long id) {
        Note note = noteService.getNoteById(id);
        User user = note.getUser();
        user.getNotes().remove(note);
        userService.saveUser(user);
        noteService.deleteNote(id);
        return "redirect:/storyDiary";
    }

    @GetMapping("/storyDiaryUpdate/{id}")
    public String updateNote(@PathVariable("id") Long id, Model model) {
        Note note = noteService.getNoteById(id);
        model.addAttribute("note", note);
        return "storyDiaryUpdate";
    }

    @PostMapping("/storyDiaryUpdate")
    public String updateNote(Note note) {
        noteService.getNoteById(note.getId());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(authentication.getName());
        noteService.updateNote(note);
        return "redirect:/storyDiary";
    }

    @GetMapping("/directoryInput")
    public String createDirectoryForm(NoteDiary notesDiary, Model model) {
        List<NoteDiary> noteDiaryList = noteDiaryService.listNotesDiary();
        model.addAttribute("notesDiary", noteDiaryList);
        return "directoryInput";
    }

    @PostMapping("/directory")
    public String createDirectory(Model model, NoteDiary noteDiary) {
        noteDiaryService.createNote(noteDiary);
        List<NoteDiary> noteList = noteDiaryService.getAllNotes();
        model.addAttribute("notesDiary", noteList);
        model.addAttribute("noteDiary", new NoteDiary()); // Add this line
        return "directoryInput";
    }

    @GetMapping("noteDiary-delete/{id}")
    public String deleteNoteDiary(@PathVariable("id") Long id) {
        noteDiaryService.deleteNote(id);
        return "redirect:/directoryInput";
    }

    @GetMapping("/directoryUpdate/{id}")
    public String updateDirectory(@PathVariable("id") Long id, Model model) {
        NoteDiary noteDiary = noteDiaryService.getNoteById(id);
        model.addAttribute("noteDiary", noteDiary);
        return "directoryUpdate";
    }

    @PostMapping("/directoryUpdate")
    public String updateDirectory(NoteDiary noteDiary) {
        noteDiaryService.updateNote(noteDiary);
        return "redirect:/directoryInput";
    }
}