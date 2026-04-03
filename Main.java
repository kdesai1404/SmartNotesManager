import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        NoteManager manager = new NoteManager();
        manager.loadNotes();

        int choice;

        do {
            System.out.println("\n===== SMART NOTES MANAGER =====");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Search Note");
            System.out.println("4. Delete Note");
            System.out.println("5. Exit");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                case 1:
                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Content: ");
                    String content = sc.nextLine();

                    System.out.print("Category: ");
                    String category = sc.nextLine();

                    manager.addNote(new Note(title, content, category));
                    break;

                case 2:
                    manager.viewNotes();
                    break;

                case 3:
                    System.out.print("Enter keyword: ");
                    manager.searchNote(sc.nextLine());
                    break;

                case 4:
                    System.out.print("Enter title to delete: ");
                    manager.deleteNote(sc.nextLine());
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    break;
            }

        } while(choice != 5);
    }
}
