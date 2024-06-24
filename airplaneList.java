package airportSimulation;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class airplaneList {
	ArrayList<airplane> airplanes=new ArrayList<airplane>();
	//create a plane
	public airplane createplane()
	{
		airplane p1=new airplane();
		return p1;
	}
	public int assignID(airplane u)
	{
		return u.giveID();
	}
	public void addplane(airplane u)
	{
		airplanes.add(u);
	}
	public void removeplane(airplane u)
	{
		airplanes.remove(u);
	}
	public void sendTaskToAirplaneList(String sec_lbl, String sup_data)
	{
		airplane v=new airplane();
		v.task_state=sec_lbl;
		v.supdata=sup_data;
		airplanes.add(v);
		System.out.println(v.task_state + " + "+ v.supdata);
	}
	public void landingtask(String sec_lbl,String sup_data)
	{
		airplane v=new airplane();
		v.task_state=sec_lbl;
		v.supdata=sup_data;
		airplanes.add(v);
		System.out.println(v.task_state + " + "+ v.supdata);
	}
	public void gettargetplane(int targetid)
	{
		airplane v;
		for(int i=0;i<airplanes.size();i++)
		{
			v=airplanes.get(i);
			if (v.ID==targetid)
			{
				System.out.println("Your plane with target Id "+ targetid+" is present on index # " + airplanes.indexOf(v));
				break;
			}
			
		}
	}
	
}

