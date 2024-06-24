package airportSimulation;

public class trafficNetworkTasks {
	
	public static int []gate=new int[1];
	public static String []runaway=new String[] {"Iqbal","Jinnah","Liaqat"};
	
	
	//give initial values to all the gates and Runaway
	public trafficNetworkTasks()
	{
		gate[0]=0;
		
	}
	public static int assignGate(String a, String b, int c, String d)
	{
		int gatenum = 0;
		for (int i=0;i<1;i++)
		{
			if (gate[i]==0)
			{
				gatenum=i;
				break;
			}
			else
			{
				TaskEngine.updatePreseviousTaskInfo();
				TaskEngine.addNewTask(a, b, Integer.toString(c)+500, d);
			}
		}
		return gatenum+1;
	}
	public static void assignRunway()
	{
		
	}
	
	public static void changeGateStatus(int u)
	{
		gate[u]=1;
	}
    public static void receiveObject(int objectID, String data) {
        System.out.println("Receiving object " + objectID + " with data: " + data);
    }

    public static void releaseObject(int objectID, String data) {
        System.out.println("Releasing object " + objectID + " with data: " + data);
    }

    public static void closeLink(String data) {
        System.out.println("Closing link with data: " + data);
    }

    public static void openLink(int objectID, String data) {
        System.out.println("Opening link " + objectID + " with data: " + data);
    }
}

