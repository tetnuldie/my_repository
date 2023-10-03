package edu.examples.java_classes.util;

import edu.examples.java_classes.dao.DaoException;

import static edu.examples.java_classes.dao.impl.FileNoteBookDao.getLastId;

public final class GenerateId {

    static {
            nextId = getLastId()+1;
    }



    private GenerateId() {
    }

    private static int nextId;

    public static int nextId() {
        return nextId++;
    }

}
