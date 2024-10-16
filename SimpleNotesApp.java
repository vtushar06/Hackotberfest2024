import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleNotesApp
{
        private List<String> notes;

        public SimpleNotesApp() {
            notes = new ArrayList<>();
        }

        // Method to add a note
        public void addNote(String note) {
            notes.add(note);
            System.out.println("Note added: " + note);
        }

        // Method to view all notes
        public void viewNotes() {
            if (notes.isEmpty()) {
                System.out.println("No notes available.");
            } else {
                System.out.println("Your Notes:");
                for (int i = 0; i < notes.size(); i++) {
                    System.out.println((i + 1) + ". " + notes.get(i));
                }
            }
        }

        // Method to delete a note
        public void deleteNote(int index) {
            if (index >= 0 && index < notes.size()) {
                String removedNote = notes.remove(index);
                System.out.println("Note deleted: " + removedNote);
            } else {
                System.out.println("Invalid note number.");
            }
        }

        public static void main(String[] args) {
            SimpleNotesApp app = new SimpleNotesApp();
            Scanner scanner = new Scanner(System.in);
            String command;

            System.out.println("Welcome to the Simple Notes Application!");

            // Command loop
            while (true) {
                System.out.println("\nEnter a command (add/view/delete/exit):");
                command = scanner.nextLine().toLowerCase();

                switch (command) {
                    case "add":
                        System.out.print("Enter your note: ");
                        String note = scanner.nextLine();
                        app.addNote(note);
                        break;
                    case "view":
                        app.viewNotes();
                        break;
                    case "delete":
                        System.out.print("Enter the note number to delete: ");
                        int noteNumber = Integer.parseInt(scanner.nextLine());
                        app.deleteNote(noteNumber - 1); // Convert to 0-based index
                        break;
                    case "exit":
                        System.out.println("Exiting the application.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid command. Please try again.");
                }
            }
        }
    }

