package es.adrianmmudarra.sendmessage.model;

import java.io.Serializable;

/**
 * <h1>Clase Message</h1>
 * <p>Clase modelo para ser enviado de forma mas limpia.</p>
 *
 * @author Adrian Muñoz
 * @version 1.0
 * @see Serializable
 */

public class Message implements Serializable {

    private String author;
    private String message;

    public Message() {
    }

    public Message(String author, String message) {
        this.author = author;
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return author + " : " + message;
    }
}
