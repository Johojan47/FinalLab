import java.util.ArrayList;
import java.util.Scanner;

public class GymTracker {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Workout> weeklyWorkouts = new ArrayList<>();
    private static final Workout[] savedWorkouts = new Workout[52];
    private static int archiveIndex = 0;

    public static void main(String[] args) {
        DataHandler.loadData(weeklyWorkouts, savedWorkouts);

        while (true) 
        {
            System.out.println("\n Hello! Welcome to the Gym Tracker Menu");
            System.out.println("1. Add Workout");
            System.out.println("2. View Weekly Workouts");
            System.out.println("3. Save Weekly Workouts");
            System.out.println("4. Save and Exit");
            System.out.print("Choose an Option: ");

            int choice = InputValidator.validatePositiveInt(scanner, "Enter your choice: ");
            switch (choice) {
                case 1:
                    addWorkout();
                    break;
                case 2:
                    viewWeeklyWorkouts();
                    break;
                case 3:
                    saveWeeklyWorkouts();
                    break;
                case 4:
                    DataHandler.saveData(weeklyWorkouts, savedWorkouts);
                    System.out.println("Data Saved. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid Choice. Please Try Again.");
            }
        }
    }

    private static void addWorkout() 
    {
        System.out.print("Enter The Day of The Week: ");
        String day = scanner.next();
        System.out.print("Enter The Type of Workout: ");
        String type = scanner.next();
        int reps = InputValidator.validatePositiveInt(scanner, "Enter The Number of Reps: ");
        int weight = InputValidator.validatePositiveInt(scanner, "Enter The Weight Used: ");

        weeklyWorkouts.add(new Workout(day, type, reps, weight));
        System.out.println("Workout Successfully Added!");
    }

    private static void viewWeeklyWorkouts() 
    {
        if (weeklyWorkouts.isEmpty()) 
        {
            System.out.println("No Workouts Were Recorded This Week. Get Back In The Gym!");
        } else 
        {
            System.out.println("\nWeekly Workouts:");
            for (Workout workout : weeklyWorkouts) 
            {
                System.out.println(workout);
            }
        }
    }

    private static void saveWeeklyWorkouts() 
    {
        if (weeklyWorkouts.isEmpty()) {
            System.out.println("No Workouts To Save");
            return;
        }

        if (archiveIndex < savedWorkouts.length) 
        {
            savedWorkouts[archiveIndex] = new Workout("Archived Week", "Summary", weeklyWorkouts.size(), 0);
            archiveIndex++;
            weeklyWorkouts.clear();
            System.out.println("Workouts Archived Successfully!");
        } else 
        {
            System.out.println("Save System Is Full. Cannot Save More Workouts");
        }
    }
}
