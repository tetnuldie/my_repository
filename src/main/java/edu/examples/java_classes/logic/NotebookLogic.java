package edu.examples.java_classes.logic;

import java.util.Date;
import java.util.List;

import edu.examples.java_classes.entity.Note;

public interface NotebookLogic {

    void add(Note n) throws LogicException;

    void add(String title, String content) throws LogicException;

    void delete() throws LogicException;

    void updateNote(int id, String title, String content) throws LogicException;

    void updateFile(List<Note> notes) throws LogicException;

    List<Note> find(String text) throws LogicException;

    Note findById(int id) throws LogicException;

    void deleteNote (int id) throws LogicException;

    List<Note> findByDate(String dateStr) throws LogicException;

    List<Note> getAllNotes() throws LogicException;




}
