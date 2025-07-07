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

class Quote {
    String text;

    Quote(String text) {
        this.text = text;
    }

    void display() {
        System.out.println("\"" + text + "\"");
        System.out.println("----------------------");
    }
}

class Dream {
    String title;
    String description;
    int progress;

    Dream(String title, String description, int progress) {
        this.title = title;
        this.description = description;
        this.progress = progress;
    }

    void updateProgress(int newProgress) {
        this.progress = newProgress;
    }

    boolean isAchieved() {
        return progress >= 100;
    }

    void display() {
        System.out.println("Dream: " + title);
        System.out.println("Description: " + description);
        System.out.println("Progress: " + progress + "%");
        System.out.println("Status: " + (isAchieved() ? "Achieved" : "In Progress"));
        System.out.println("----------------------");
    }
}

public class VibeLogger {
    static Scanner sc = new Scanner(System.in);

    static ArrayList<Mood> moodList = new ArrayList<>();
    static ArrayList<Quote> quoteList = new ArrayList<>();
    static ArrayList<Dream> dreamList = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Vibe Logger ---");
            System.out.println("1. Log today's mood");
            System.out.println("2. View all logged moods");
            System.out.println("3. Add a quote or thought");
            System.out.println("4. View all saved quotes");
            System.out.println("5. Add a dream or goal");
            System.out.println("6. View all dreams");
            System.out.println("7. Update dream progress");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    logMood();
                    break;
                case 2:
                    showMoods();
                    break;
                case 3:
                    addQuote();
                    break;
                case 4:
                    showQuotes();
                    break;
                case 5:
                    addDream();
                    break;
                case 6:
                    showDreams();
                    break;
                case 7:
                    updateDream();
                    break;
                case 8:
                    System.out.println("Exiting Vibe Logger...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (true);
    }

    static void logMood() {
        System.out.print("How are you feeling today? ");
        String feeling = sc.nextLine();
        System.out.print("Want to add a note? ");
        String note = sc.nextLine();

        Mood m = new Mood(feeling, note);
        moodList.add(m);
        System.out.println("Mood logged.");
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

    static void addQuote() {
        System.out.print("Type your quote, lyric, or thought: ");
        String text = sc.nextLine();
        Quote q = new Quote(text);
        quoteList.add(q);
        System.out.println("Quote saved.");
    }

    static void showQuotes() {
        if (quoteList.isEmpty()) {
            System.out.println("No quotes saved yet.");
            return;
        }
        for (Quote q : quoteList) {
            q.display();
        }
    }

    static void addDream() {
        System.out.print("Enter dream/goal title: ");
        String title = sc.nextLine();
        System.out.print("Describe the dream: ");
        String desc = sc.nextLine();
        System.out.print("Initial progress (0-100): ");
        int progress = sc.nextInt();
        sc.nextLine();

        Dream d = new Dream(title, desc, progress);
        dreamList.add(d);
        System.out.println("Dream added.");
    }

    static void showDreams() {
        if (dreamList.isEmpty()) {
            System.out.println("No dreams added yet.");
            return;
        }
        for (Dream d : dreamList) {
            d.display();
        }
    }

    static void updateDream() {
        if (dreamList.isEmpty()) {
            System.out.println("No dreams to update.");
            return;
        }

        System.out.print("Enter title of the dream to update: ");
        String searchTitle = sc.nextLine();

        for (Dream d : dreamList) {
            if (d.title.equalsIgnoreCase(searchTitle)) {
                System.out.print("Enter new progress (0-100): ");
                int newProgress = sc.nextInt();
                sc.nextLine();
                d.updateProgress(newProgress);
                System.out.println("Dream updated.");
                return;
            }
        }
        System.out.println("Dream not found.");
    }
}
