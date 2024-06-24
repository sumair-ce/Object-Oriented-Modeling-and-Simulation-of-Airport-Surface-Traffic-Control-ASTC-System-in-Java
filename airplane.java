package airportSimulation;
import java.util.Random;
public class airplane {
	public int ID;
	public String task_state;
	public String supdata;
	public airplanestates state;
    public String orientation;
    public String entryPoint;
    public String destination;
    public String currentPosition;
    public String nextPosition;
    
    
	Random random=new Random();
	public String task;
	public int giveID()
	{
		ID=random.nextInt(100);
		System.out.println("Here: "+ ID);
		return ID;
	}
	public int getid()
	{
		return ID;
		
	}
	

}
