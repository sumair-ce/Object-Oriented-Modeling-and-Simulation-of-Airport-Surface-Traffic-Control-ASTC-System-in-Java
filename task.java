package airportSimulation;

public class task {
	String primaryLabel;
    String secondaryLabel;
    int priority;
    String supplementalData;
    
    public String getPrimaryLabel()
    {
        return primaryLabel;
    }

    public String getSecondaryLabel()
    {
        return secondaryLabel;
    }

    public int getPriority()
    {
        return priority;
    }
    @Override
    public String toString() {
        return "Task: " + primaryLabel + ", " + secondaryLabel + ", " + priority + ", " + supplementalData;
    }

}
