package edu.examples.java_classes.logic.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import edu.examples.java_classes.dao.DaoException;
import edu.examples.java_classes.dao.DaoProvider;
import edu.examples.java_classes.dao.NoteBookDao;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.NotebookLogic;

public class NotebookLogicImpl implements NotebookLogic {
    private final DaoProvider provider = DaoProvider.getInstance();
    private final NoteBookDao dao = provider.getNoteBookDao();

    public void add(Note n) throws LogicException {
        try {
            dao.save(n);
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    public void add(String title, String content) throws LogicException {

        Note n = new Note(title, content);

        try {
            dao.save(n);
        } catch (DaoException e) {
            throw new LogicException(e);
        }

    }

    public List<Note> find(String text) throws LogicException {

        List<Note> result = new ArrayList<>();

        // NoteBookDao dao = new NoteBookDao();
        List<Note> myNotes = allNotes();

        for (Note n : myNotes) {
            if (isTextInNote(n, text)) {
                result.add(n);
            }
        }

        return result;

    }

    @Override
    public Note findById(int id) throws LogicException {

        List<Note> myNotes = allNotes();

        for (Note n : myNotes) {
            if (n.getId() == id) {
                return n;
            }
        }
        throw new LogicException("Not found by given id");
    }

    @Override
    public void deleteNote(int id) throws LogicException {
        try {
            isIdExist(id);
        } catch (LogicException e) {
            throw new LogicException(e);
        }

        List<Note> notes = allNotes();
        for (Note m : notes) {
            if (m.getId() == id) {
                notes.remove(m);
                break;
            }
        }
        updateFile(notes);
    }

    private boolean isTextInNote(Note n, String text) throws LogicException {
        return n.getTitle().toLowerCase().contains(text.toLowerCase()) ||
                n.getContent().toLowerCase().contains(text.toLowerCase());
    }

    private boolean isIdExist(int id) throws LogicException {
        Note n = findById(id);
        return n != null;
    }




    public List<Note> findByDate(String dateStr) throws LogicException {

        List<Note> result = new ArrayList<>();

        List<Note> myNotes = allNotes();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date dateToFind;

        try {
            Date date = df.parse(dateStr);
            dateToFind = date;
        } catch (ParseException e) {
            throw new LogicException(e);
        }

        for (Note n : myNotes) {
            if (n.getD().getTime() >= dateToFind.getTime() &&
                n.getD().getTime() <= dateToFind.getTime() + 86400000) {
                result.add(n);
            }

        }
        return result;
    }

    @Override
    public List<Note> getAllNotes() throws LogicException {
        return allNotes();
    }


    private List<Note> allNotes() throws LogicException {
        try {
            return dao.getNotes();
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    @Override
    public void delete() throws LogicException {
        try {
            dao.deleteNotes();
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    @Override
    public void updateNote(int id, String title, String content) throws LogicException {

        try {
            isIdExist(id);
        } catch (LogicException e) {
            throw new LogicException(e);
        }

        List<Note> notes = allNotes();
        for (Note m : notes) {
            if (m.getId() == id) {
                m.setContent(content);
                m.setTitle(title);
                m.setD(new Date());
                break;
            }
        }
        updateFile(notes);
    }

    @Override
    public void updateFile(List<Note> notes) throws LogicException {
        delete();
        for (Note n : notes) {
            add(n);
        }
    }

}
