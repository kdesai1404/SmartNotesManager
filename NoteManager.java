import java.io.*;
import java.util.*;

public class NoteManager {

    private ArrayList<Note> notes = new ArrayList<>();
    private final String FILE_NAME = "data/notes.txt";

    public void addNote(Note note) {
        notes.add(note);
        saveNotes();
    }

    public void viewNotes() {
        if (notes.isEmpty()) {
            System.out.println("No notes available.");
            return;
        }
        for (Note n : notes)
            n.display();
    }

    public void searchNote(String keyword) {
        for (Note n : notes) {
            if (n.getTitle().contains(keyword))
                n.display();
        }
    }

    public void deleteNote(String title) {
        notes.removeIf(n -> n.getTitle().equalsIgnoreCase(title));
        saveNotes();
    }

    public void saveNotes() {
        try (ObjectOutputStream oos =
                 new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(notes);
        } catch (Exception e) {
            System.out.println("Error saving notes.");
        }
    }

    public void loadNotes() {
        try (ObjectInputStream ois =
                 new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            notes = (ArrayList<Note>) ois.readObject();
        } catch (Exception e) {
            notes = new ArrayList<>();
        }
    }
}
