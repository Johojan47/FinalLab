import java.io.*;
import java.util.ArrayList;

public class DataHandler {

    public static void saveData(ArrayList<Workout> weeklyWorkouts, Workout[] savedWorkouts)
    {
        try (ObjectOutputStream weeklyOut = new ObjectOutputStream(new FileOutputStream("weeklyWorkouts.dat"));
             ObjectOutputStream savedOut = new ObjectOutputStream(new FileOutputStream("savedWorkouts.dat")))
             {
                weeklyOut.writeObject(new ArrayList<>(weeklyWorkouts));
                savedOut.writeObject(savedWorkouts);

                System.out.println("Data Saved!!");
             }
        catch (Exception e) {
                System.out.println("Error Saving Data: " + e.getMessage());
             }
    }

    public static void loadData(ArrayList<Workout> weeklyWorkouts, Workout[] savedWorkouts) 
    {
        try (ObjectInputStream weeklyIn = new ObjectInputStream(new FileInputStream("weeklyWorkouts.dat"));
             ObjectInputStream savedIn = new ObjectInputStream(new FileInputStream("savedWorkouts.dat")))
             {
                ArrayList<Workout> loadedWorkouts = (ArrayList<Workout>) weeklyIn.readObject();
                weeklyWorkouts.addAll(loadedWorkouts);

                Workout[] loadedSaved = (Workout[]) savedIn.readObject();
                System.arraycopy(loadedSaved, 0, savedWorkouts, 0, loadedSaved.length);
             }

        catch (FileNotFoundException e)
        {
            System.out.println("No Previous Data Was Found.");
        }
        catch (IOException | ClassNotFoundException e)
        {
            System.out.println("Error Loading The Data: " + e.getMessage());
        }

    }
}
