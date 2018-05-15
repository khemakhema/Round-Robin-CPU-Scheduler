package cpu_scheduling;

//cpu class to hold processes
public class CPU
{
	public Process running;
	public int timeSpent; //counter
	
	public CPU()
	{
		running = null;
	}

}
