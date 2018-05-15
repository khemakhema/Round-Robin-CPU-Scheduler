package cpu_scheduling;
import java.util.*;
import java.io.*;
//Alexander Khemai
//CSCI 330-M02
//1 Dec 2017
public class Test
{
	public int timeQuantum;
	public String csv;
	public BufferedReader br;
	public String line = "";
	static Scanner kb = new Scanner(System.in);
	static int tq;
	
	public ArrayList<Process> getArraylist() throws IOException
	{
		ArrayList<Process> proc = new ArrayList();
		br = new BufferedReader(new FileReader(csv)); //read csv file
		br.readLine();
		while ((line = br.readLine()) != null) 
		{
			String[] arr = line.split(","); //split commas
			Process p = new Process(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]) ,Integer.parseInt(arr[2])); //convert string to int using the index of array
			proc.add(p);
	
		}
		
		return proc;
	}
	public static void main(String[] args) throws IOException
	{
		System.out.println("Enter a time quantum: ");
		tq = kb.nextInt();
		Test test = new Test ("input.csv", tq); //take csv file and time quantum
		RoundRobinSim rr = new RoundRobinSim(test.getArraylist(), test.timeQuantum);
		rr.Scheduling();
	}
	public Test (String csv, int timeQuantum)
	{
		this.csv = csv;
		this.timeQuantum = timeQuantum;
	}

}
