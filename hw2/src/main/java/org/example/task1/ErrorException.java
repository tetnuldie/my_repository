package org.example.task1;

import java.io.Serial;

public class ErrorException extends Exception{
    @Serial
    private static final long serialVersionUID = 1L;

    public ErrorException(){
        super();
    }

    public ErrorException(String message){
        super(message);
    }

    public ErrorException(Exception e){
        super(e);
    }

    public ErrorException(String message, Exception e){
        super(message, e);
    }
}
