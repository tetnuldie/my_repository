package edu.examples.java_classes.dao.impl;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import edu.examples.java_classes.dao.DaoException;
import edu.examples.java_classes.dao.NoteBookDao;
import edu.examples.java_classes.entity.Note;

public class FileNoteBookDao implements NoteBookDao {

	private final File file = new File("D:\\Notebook\\Final\\notebook_mv\\notebook_mv\\src\\main\\resources\\notes.txt");

	@Override
	public void save(Note n) throws DaoException{

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
			bw.write(n.toString()+"\n");
		} catch (IOException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public List<Note> getNotes() throws DaoException{
		List<Note> notes = new ArrayList<>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			String[] parts;
			while ((line = br.readLine()) != null) {
				parts = line.split(",\\s+");
				Date date = dateFormat.parse(parts[3]);

				notes.add(new Note(Integer.parseInt(parts[0]),parts[1],parts[2],date));
			}
		} catch (IOException | ParseException e) {
			throw new DaoException(e);
		}
		return notes;
	}


	@Override
	public void deleteNotes() throws DaoException {

		try {
			FileWriter fileWriter = new FileWriter(file, false);
			fileWriter.close();

		} catch (IOException e) {
			throw new DaoException(e);
		}
	}

}
