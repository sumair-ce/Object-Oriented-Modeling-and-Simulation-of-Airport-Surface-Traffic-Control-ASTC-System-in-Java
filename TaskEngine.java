package airportSimulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

import javax.swing.SwingUtilities;

import java.util.ArrayList;
import java.util.Comparator;
import java.io.File;

public class TaskEngine implements Runnable{
	
	ArrayList<Integer> taskqueue_priority=new ArrayList<Integer>();
	static ArrayList<task> mytasklist = new ArrayList<task>();
	static ArrayList<task> samePriorityTaskList = new ArrayList<task>();
	public static boolean isFirstDispatch = true;
	
	public TaskEngine(ArrayList<task> taskList) {
        this.mytasklist = taskList;
    }
	
	
	public TaskEngine() {}


	static AirportFrame frame = new AirportFrame();
	public static void collectData()
	{
		try(BufferedReader br=new BufferedReader(new FileReader("taskfilelist.txt")))
		{
			
			String line;
			while ((line=br.readLine()) != null)
			{
				task t = new task();
				
				String[] partsOfLine= line.split(",");
				if (partsOfLine.length>=4)
				{
					t.primaryLabel = partsOfLine[0];
                    t.secondaryLabel = partsOfLine[1];
                    t.priority = Integer.parseInt(partsOfLine[2]);
                    t.supplementalData = partsOfLine[3];
                    mytasklist.add(t);
                    
				}
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
	
	
	public static void mySort() {
	    for (int i = 0; i < mytasklist.size() - 1; i++) {
	        for (int j = 0; j < mytasklist.size() - i - 1; j++) {
	            int priorityComparison = Integer.compare(mytasklist.get(j).priority, mytasklist.get(j + 1).priority);

	            if (priorityComparison > 0 || 
	                (priorityComparison == 0 && 
	                 "Exit an Airplane Task".equals(mytasklist.get(j).secondaryLabel) &&
	                 "Land an Airplane Task".equals(mytasklist.get(j + 1).secondaryLabel))) {

	                task temp = mytasklist.get(j);
	                mytasklist.set(j, mytasklist.get(j + 1));
	                mytasklist.set(j + 1, temp);

	                if ("Exit an Airplane Task".equals(mytasklist.get(j).secondaryLabel) &&
	                    "Land an Airplane Task".equals(mytasklist.get(j + 1).secondaryLabel)) {
	                    mytasklist.get(j + 1).priority += 10;
	                    System.out.println(mytasklist.get(j + 1).priority);
	                }
	                
	            }
	        }
	    }
	    
	    
	}
	public void seperatetasks()
	{
		for (int j=0;j<mytasklist.size()-1;j++) {
			if (mytasklist.get(j).priority==mytasklist.get(j+1).priority) {
				task temp=mytasklist.get(j+1);
				samePriorityTaskList.add(temp);
				mytasklist.remove(j+1);
            }
		}

	}
//	for (task t : mytasklist) {
//    System.out.println("Priority: " + t.priority + ", Secondary Label: " + t.secondaryLabel);
//}
//System.out.println("here.................");
//for (task t : samePriorityTaskList) {
//    System.out.println("Priority: " + t.priority + ", Secondary Label: " + t.secondaryLabel);
//}
	public void addtime()
	{
		
		for (int j=0;j<mytasklist.size()-1;j++) {
			if ((mytasklist.get(j).primaryLabel.equals(mytasklist.get(j+1).primaryLabel))&&(mytasklist.get(j).priority==mytasklist.get(j+1).priority))
			{
				mytasklist.get(j + 1).priority += 10;
			}
		}
		
	}

	
	
	public static void closeframe()
	{
		frame.setVisible(false);
	}
	
	public static void openframe()
	{
		frame.setVisible(true);
	}
	static String z;
//	//this is my function that will dispatch the tasks and will call the respective processor for its function to perform
	public static void dispatchTask()
	{
		int j=0;
		frame.setVisible(true);
		airplaneList listOfAirplanes=new airplaneList();
		globalclock c=new globalclock();
		int i=0,t=0;
		task temp=mytasklist.get(i);
		c.gettime();
		
		while (mytasklist.size()!=0)
		{
			
			frame.nexttask(temp.primaryLabel,temp.secondaryLabel,temp.priority);
			if (temp.priority==c.printtime())
			{
				if ("Airplane".equals(temp.primaryLabel))
				{
					//create a plane, assign an id to that airplane
					//add that plane to the list
					airplane a;
					a=listOfAirplanes.createplane();
					int id=listOfAirplanes.assignID(a);
					listOfAirplanes.addplane(a);

					System.out.println(id);
					//this switch case with dispatch task depending upon secondary label
					switch (temp.secondaryLabel) {
                    case "Land an Airplane Task":
                    	String[] runawayData = temp.supplementalData.split("/");
                    	int gatenumber=trafficNetworkTasks.assignGate(temp.primaryLabel,temp.secondaryLabel,temp.priority,temp.supplementalData);
                        airplaneTasks.landAirplane(id, runawayData[0], gatenumber);
                        z="Airplane with "+id+" had landed at runway " + runawayData[0] + " and gate # "+gatenumber;
                        trafficNetworkTasks.changeGateStatus(gatenumber-1);
                        frame.additionalInfo(z);
                        mytasklist.remove(i);
                        break;
                    case "Exit an Airplane Task":
                        String[] exitData = temp.supplementalData.split("/");
                        airplaneTasks.exitLink(id, exitData[0], exitData[1]);
                        int gatenumber1=trafficNetworkTasks.assignGate(temp.primaryLabel,temp.secondaryLabel,temp.priority,temp.supplementalData);
                        z="Airplane with id "+id+" has exited from "+exitData[0]+" to "+exitData[1] +" at gate # "+gatenumber1;
                        trafficNetworkTasks.changeGateStatus(gatenumber1-1);
                        frame.additionalInfo(z);
                        mytasklist.remove(i);
                        break;
                    case "Enter a Link Task":
                    	
                    	String[] enterData = temp.supplementalData.split(",");
                        int gatenumber2=trafficNetworkTasks.assignGate(temp.primaryLabel,temp.secondaryLabel,temp.priority,temp.supplementalData);
                        airplaneTasks.enterLink(temp.secondaryLabel, enterData[0], enterData[1]);
                        z="Airplane with id "+id+" has entered from "+enterData[0]+" to "+enterData[1] +" at gate # "+ gatenumber2;
                        trafficNetworkTasks.changeGateStatus(gatenumber2-1);
                        frame.additionalInfo(z);
                        mytasklist.remove(i);
                        break;
                    default:
                        System.out.println("Primary Label does not match with any Secondary Label");
                        mytasklist.remove(i);
                        break;
                }
	            }
				else if("Airport".equals(temp.primaryLabel))
				{
					airplane a;
					a=listOfAirplanes.createplane();
					int id=listOfAirplanes.assignID(a);
					listOfAirplanes.addplane(a);
					
					System.out.println(id);
					// this switch case will dispatch tasks of airport based on secondary label
					switch (temp.secondaryLabel) {
                    case "Receive an Object Task":
                    	trafficNetworkTasks.receiveObject(id, temp.supplementalData);
                        int gatenumber=trafficNetworkTasks.assignGate(temp.primaryLabel,temp.secondaryLabel,temp.priority,temp.supplementalData);
                        z="Airport has received the Airplane with id " + id +" at gate # "+gatenumber;
                        trafficNetworkTasks.changeGateStatus(gatenumber-1);
                        frame.additionalInfo(z);
                        mytasklist.remove(i);
                        break;
                    case "Release an Object Task":
                    	int gatenumber1=trafficNetworkTasks.assignGate(temp.primaryLabel,temp.secondaryLabel,temp.priority,temp.supplementalData);
                        trafficNetworkTasks.releaseObject(id, temp.supplementalData);
                        z="Airport has released the Airplane with id " + id + " at gate # "+ gatenumber1;
                        trafficNetworkTasks.changeGateStatus(gatenumber1-1);
                        frame.additionalInfo(z);
                        mytasklist.remove(i);
                        break;
                    case "Close This Link Task":
                        trafficNetworkTasks.closeLink(temp.supplementalData);
                        z="Airport has closed the link ";
                        frame.additionalInfo(z);
                        mytasklist.remove(i);
                        break;
                    case "Open This Link Task":
                        trafficNetworkTasks.openLink(id, temp.supplementalData);
                        z="Airport has Opened the link ";
                        frame.additionalInfo(z);
                        mytasklist.remove(i);
                        break;
                    default:
                        System.out.println("Primary Label does not match with any Secondary Label");
                        mytasklist.remove(i);
                        break;
					}
	            }
				else if("Traffic Control".equals(temp.primaryLabel))
				{
					airplane a;
					a=listOfAirplanes.createplane();
					int id=listOfAirplanes.assignID(a);
					listOfAirplanes.addplane(a);
					
					System.out.println(id);
					// this switch case will dispatch tasks of airport based on secondary label
					switch (temp.secondaryLabel) {
                    case "Move an Airplane Task":
                    	String[] linkData = temp.supplementalData.split("/");
                    	trafficControlTasks.moveAirplane(id,linkData[0],linkData[1]);
                    	z="Traffic Control tower has moved the airplane with id "+id+ " from link " + linkData[0]+" to link "+linkData[1];
                        frame.additionalInfo(z);
                        mytasklist.remove(i);
                        break;
                    case "Hold an Airplane Task":
                    	trafficControlTasks.holdAirplane(id,temp.supplementalData );
                        z="Traffic Control tower has hold the airplane with id "+id+ " at link " + temp.supplementalData;
                        frame.additionalInfo(z);
                        mytasklist.remove(i);
                        break;
                    case "Parking an Airplane Task":
                    	trafficControlTasks.parkAirplane(id,temp.supplementalData );
                        z="Traffic Control tower has parked the airplane with id "+id+ " at link " + temp.supplementalData;
                        frame.additionalInfo(z);
                        mytasklist.remove(i);
                        break;
                    default:
                        System.out.println("Primary Label does not match with any Secondary Label");
                        mytasklist.remove(i);
                        break;
					}
	            }
				else if ("Shortest Path".equals(temp.primaryLabel))
				{
	                // Handle Shortest Path task
	            }
				else
				{
	                System.out.println("Primary Label does not match with any Class");
	            }
				if(mytasklist.isEmpty()==true)
				{
					System.out.println("No more task to dispatch, Task List is now empty");
					break;
				}
				temp=mytasklist.get(i);
			}
			//this try catch block will give 1 second sleep to my while loop for avoiding rapid loop
			try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		}
	}
	@Override
	public void run()
	{
		dispatchTask();
	}
	
	static displaySameTaskFrame sametaskframe = new displaySameTaskFrame();
	public static void dispatchsametask()
	{
		int j=0;
		sametaskframe.setVisible(true);
		airplaneList listOfAirplanes=new airplaneList();
		globalclock c=new globalclock();
		int i=0,t=0;
		task temp=samePriorityTaskList.get(i);
		c.gettime();
		
		while (samePriorityTaskList.size()!=0)
		{
			sametaskframe.nexttask(temp.primaryLabel,temp.secondaryLabel,temp.priority);
			if (temp.priority==c.printtime())
			{
				if ("Airplane".equals(temp.primaryLabel))
				{
					//create a plane, assign an id to that airplane
					//add that plane to the list
					airplane a;
					a=listOfAirplanes.createplane();
					int id=listOfAirplanes.assignID(a);
					listOfAirplanes.addplane(a);

					System.out.println(id);
					//this switch case with dispatch task depending upon secondary label
					switch (temp.secondaryLabel) {
                    case "Land an Airplane Task":
                    	String[] runawayData = temp.supplementalData.split("/");
                    	int gatenumber=trafficNetworkTasks.assignGate(temp.primaryLabel,temp.secondaryLabel,temp.priority,temp.supplementalData);
                        airplaneTasks.landAirplane(id, runawayData[0], gatenumber);
                        z="Airplane with "+id+" had landed at runway " + runawayData[0] + " and gate # "+gatenumber;
                        trafficNetworkTasks.changeGateStatus(gatenumber-1);
                        sametaskframe.additionalInfo(z);
                        samePriorityTaskList.remove(i);
                        break;
                    case "Exit a Link Task":
                        String[] exitData = temp.supplementalData.split("/");
                        airplaneTasks.exitLink(id, exitData[0], exitData[1]);
                        int gatenumber1=trafficNetworkTasks.assignGate(temp.primaryLabel,temp.secondaryLabel,temp.priority,temp.supplementalData);
                        z="Airplane with id "+id+" has exited from "+exitData[0]+" to "+exitData[1] +" at gate # "+gatenumber1;
                        trafficNetworkTasks.changeGateStatus(gatenumber1-1);
                        sametaskframe.additionalInfo(z);
                        samePriorityTaskList.remove(i);
                        break;
                    case "Enter a Link Task":
                    	
                        String[] enterData = temp.supplementalData.split(",");
                        int gatenumber2=trafficNetworkTasks.assignGate(temp.primaryLabel,temp.secondaryLabel,temp.priority,temp.supplementalData);
                        airplaneTasks.enterLink(temp.secondaryLabel, enterData[0], enterData[1]);
                        z="Airplane with id "+id+" has entered from "+enterData[0]+" to "+enterData[1] +" at gate # "+ gatenumber2;
                        trafficNetworkTasks.changeGateStatus(gatenumber2-1);
                        sametaskframe.additionalInfo(z);
                        samePriorityTaskList.remove(i);
                        break;
                    default:
                        System.out.println("Primary Label does not match with any Secondary Label");
                        samePriorityTaskList.remove(i);
                        break;
                }
	            }
				else if("Airport".equals(temp.primaryLabel))
				{
					airplane a;
					a=listOfAirplanes.createplane();
					int id=listOfAirplanes.assignID(a);
					listOfAirplanes.addplane(a);
					
					System.out.println(id);
					// this switch case will dispatch tasks of airport based on secondary label
					switch (temp.secondaryLabel) {
                    case "Receive an Object Task":
                        trafficNetworkTasks.receiveObject(id, temp.supplementalData);
                        int gatenumber=trafficNetworkTasks.assignGate(temp.primaryLabel,temp.secondaryLabel,temp.priority,temp.supplementalData);
                        z="Airport has received the Airplane with id " + id +" at gate # "+gatenumber;
                        trafficNetworkTasks.changeGateStatus(gatenumber-1);
                        sametaskframe.additionalInfo(z);
                        samePriorityTaskList.remove(i);
                        break;
                    case "Release an Object Task":
                    	int gatenumber1=trafficNetworkTasks.assignGate(temp.primaryLabel,temp.secondaryLabel,temp.priority,temp.supplementalData);
                        trafficNetworkTasks.releaseObject(id, temp.supplementalData);
                        z="Airport has released the Airplane with id " + id + " at gate # "+ gatenumber1;
                        trafficNetworkTasks.changeGateStatus(gatenumber1-1);
                        sametaskframe.additionalInfo(z);
                        samePriorityTaskList.remove(i);
                        break;
                    case "Close This Link Task":
                        trafficNetworkTasks.closeLink(temp.supplementalData);
                        z="Airport has closed the link ";
                        sametaskframe.additionalInfo(z);
                        samePriorityTaskList.remove(i);
                        break;
                    case "Open This Link Task":
                        trafficNetworkTasks.openLink(id, temp.supplementalData);
                        z="Airport has Opened the link ";
                        sametaskframe.additionalInfo(z);
                        samePriorityTaskList.remove(i);
                        break;
                    default:
                        System.out.println("Primary Label does not match with any Secondary Label");
                        samePriorityTaskList.remove(i);
                        break;
					}
	            }
				else if("Traffic Control".equals(temp.primaryLabel))
				{
					airplane a;
					a=listOfAirplanes.createplane();
					int id=listOfAirplanes.assignID(a);
					listOfAirplanes.addplane(a);
					
					System.out.println(id);
					// this switch case will dispatch tasks of airport based on secondary label
					switch (temp.secondaryLabel) {
                    case "Move an Airplane Task":
                    	String[] linkData = temp.supplementalData.split("/");
                    	trafficControlTasks.moveAirplane(id,linkData[0],linkData[1]);
                    	z="Traffic Control tower has moved the airplane with id "+id+ " from link " + linkData[0]+" to link "+linkData[1];
                    	sametaskframe.additionalInfo(z);
                        samePriorityTaskList.remove(i);
                        break;
                    case "Hold an Airplane Task":
                        trafficControlTasks.holdAirplane(id,temp.supplementalData );
                        z="Traffic Control tower has hold the airplane with id "+id+ " at link " + temp.supplementalData;
                        sametaskframe.additionalInfo(z);
                        samePriorityTaskList.remove(i);
                        break;
                    case "Parking an Airplane Task":
                        trafficControlTasks.parkAirplane(id,temp.supplementalData);
                        z="Traffic Control tower has parked the airplane with id "+id+ " at link " + temp.supplementalData;
                        sametaskframe.additionalInfo(z);
                        samePriorityTaskList.remove(i);
                        break;
                    default:
                        System.out.println("Primary Label does not match with any Secondary Label");
                        samePriorityTaskList.remove(i);
                        break;
					}
	            }
				else
				{
	                System.out.println("Primary Label does not match with any Class");
	            }
				if(samePriorityTaskList.isEmpty()==true)
				{
					System.out.println("No more task to dispatch, Task List is now empty");
					break;
				}
				temp=samePriorityTaskList.get(i);
			}
			//this try catch block will give 1 second sleep to my while loop for avoiding rapid loop
			try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		}
	}
	
	public static void updatePreseviousTaskInfo()
	{
		sametaskframe.additionalInfo("Gate is not Available");
	}
	
	
	
	public static void addNewTask(String a, String b, String c, String d) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("taskfilelist.txt", true))) {
            Scanner scanner = new Scanner(System.in);

            String primaryLabel = a;
            String secondaryLabel = b;
            String priority = c;
            String supplementaryData = d;
            String formattedData = String.format("%s,%s,%s,%s", primaryLabel, secondaryLabel, priority, supplementaryData);

            writer.write(formattedData);
            writer.newLine(); // add a newline

            System.out.println("Data saved successfully!");
            

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }
}

