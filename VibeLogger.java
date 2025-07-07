import java.util.ArrayList;
import java.util.Scanner;

class Mood {
    String feeling;
    String note;

    Mood(String feeling, String note) {
        this.feeling = feeling;
        this.note = note;
    }

    void display() {
        System.out.println("Mood: " + feeling);
        System.out.println("Note: " + note);
        System.out.println("----------------------");
    }
}

public class VibeLogger {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Mood> moodList = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Vibe Logger ---");
            System.out.println("1. Log today's mood");
            System.out.println("2. View all logged moods");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    logMood();
                    break;
                case 2:
                    showMoods();
                    break;
                case 3:
                    System.out.println("Exiting... Stay real. ✌️");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 3);
    }

    static void logMood() {
        System.out.print("How are you feeling today? ");
        String feeling = sc.nextLine();
        System.out.print("Wanna say anything else about it? ");
        String note = sc.nextLine();

        Mood m = new Mood(feeling, note);
        moodList.add(m);
        System.out.println("Mood logged! Keep vibin'.");
    }

    static void showMoods() {
        if (moodList.isEmpty()) {
            System.out.println("No moods logged yet.");
            return;
        }
        for (Mood m : moodList) {
            m.display();
        }
    }
}
