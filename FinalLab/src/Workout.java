import java.io.Serializable;

public class Workout implements Serializable{

    private String day;
    private String type;
    private int reps;
    private int weight;

    public Workout(String day, String type, int reps, int weight)
    {
        this.day = day;
        this.type = type;
        this.reps = reps;
        this.weight = weight;
    }

    @Override
    public String toString()
    {
        return "Day: " + day + ", Type: " + type + ", Reps: " + reps + ", Weight: " + weight + " lbs";
    }
    
}
