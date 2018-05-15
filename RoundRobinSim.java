package cpu_scheduling;
import java.util.*;

public class RoundRobinSim
{
	public ArrayList<Process> readyqueue;
	public ArrayList<Process> processes;
	public ArrayList<Process> info; //arraylist with the info of process after it has finished
	public int timeQuantum;
	public int currentTime;
	public double avgWaitTime; //end print
	public double avgTurnAroundTime; //end print
	public double throughput;
	public int contextSwitchTime;
	public double totalBurstTime;
	
	
	public RoundRobinSim(ArrayList<Process> processes, int timeQuantum)
	{
		this.processes = processes;
		this.timeQuantum = timeQuantum;
	}
	public void Scheduling()
	{
		
		CPU cp = new CPU(); //new cpu 
		readyqueue = new ArrayList<>(); //readyqueue created
		info = new ArrayList<>(); 
		currentTime = 0;
		avgTurnAroundTime = 0;
		contextSwitchTime = 0;
		totalBurstTime = 0;
		while(!readyqueue.isEmpty() || !processes.isEmpty() || cp.running != null){ //adding processes to readyqueue
			for(int i=0; i < processes.size(); i++) //for loop to gather processes and add it to ready queue
			{
				if(processes.get(i).arrivalTime == currentTime)
					readyqueue.add(processes.remove(i));
			}
			if(cp.running == null)
				cp.running = readyqueue.remove(0); //return the first element of ready queue
			
			cp.timeSpent++; //increment timeSpent
			cp.running.serviceTime++; //increment serviceTime
			
			if(cp.running.burstTime == cp.running.serviceTime)  //if burstTime is the same as serviceTime
			{
				info.add(cp.running);
				cp.running.completionTime = currentTime;
				cp.running = null;
				cp.timeSpent = 0;
				contextSwitchTime++;
			}
			else if(timeQuantum == cp.timeSpent) //if time quantum has expired
			{
				readyqueue.add(cp.running);
				cp.running = null;
				cp.timeSpent = 0;
				contextSwitchTime++;
			}
			currentTime++;
		}
		
		for(int i = 0; i < info.size(); i++)
		{
			avgTurnAroundTime += info.get(i).completionTime - info.get(i).arrivalTime;
			avgWaitTime += (info.get(i).completionTime - info.get(i).arrivalTime) - info.get(i).burstTime;
			totalBurstTime += info.get(i).burstTime;
		}
		avgTurnAroundTime = avgTurnAroundTime / info.size();
		avgWaitTime = avgWaitTime / info.size();
		throughput = (double)info.size() / currentTime;
		
		System.out.println("CPU Utilization " + ((totalBurstTime - (contextSwitchTime * 0.01)) / currentTime) * 100 + "%"); 
		System.out.println("Throughput: " + (throughput));
		System.out.println("Average waiting time: " + (avgWaitTime));
		System.out.println("Average turnaround time: " + (avgTurnAroundTime));
		
	}

	
	

}
