package cpu_scheduling;

public class Process
{
	public int processID, arrivalTime, burstTime, serviceTime, completionTime;
	
	public Process(int processID, int arrivalTime , int burstTime) 
	{						
		this.processID = processID;
		this.burstTime = burstTime;
		this.arrivalTime = arrivalTime;
		
	}
	public void setBurstTime(int burstTime)
	{
		this.burstTime = burstTime;
	}
	public int getBurstTime()
	{
		return burstTime;
	}
	public void setArrivalTime(int arrivalTime)
	{
		this.arrivalTime = arrivalTime;
	}
	public int getArrivalTime()
	{
		return arrivalTime;
	}

}
	