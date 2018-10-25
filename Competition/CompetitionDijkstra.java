import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestants’
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *     Each contestant walks at a given estimated speed.
 *     The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Dijkstra's algorithm
 */

public class CompetitionDijkstra {

	public static int V;
	public final int MAX_ERROR = 2147483647;
	public int sA;
	public int sB;
	public int sC;
	public String filename;
	public int slowestSpeed;
	public double graph[][];
	public double dist[];
	public int intersection;
	public int errorCheck;
	public double longest;

	/**
	 * @param filename: A filename containing the details of the city road network
	 * @param sA, sB, sC: speeds for 3 contestants
	 */
	CompetitionDijkstra (String filename, int sA, int sB, int sC)
	{
		longest = 0;
		errorCheck =0;
		try
		{
			this.filename = filename;
			File file = new File(this.filename);
			Scanner sc = new Scanner(file);
			this.V = sc.nextInt();
			this.sA = sA;
			this.sB = sB;
			this.sC = sC;
			this.slowestSpeed = Math.min(sA, sB);
			this.slowestSpeed = Math.min(slowestSpeed, sC);
			this.graph = new double[V][V];

			this.intersection = sc.nextInt();
			for (int i =0; i<intersection; i++)
			{
				int node1 = sc.nextInt();
				int node2 = sc.nextInt();
				double weight = sc.nextDouble();
				this.graph[node1][node2] = weight;
			}
			sc.close();
		}
		catch(FileNotFoundException|NullPointerException e)
		{
			errorCheck = -1;
		}
		
		
		for (int src =0; src<V;src++)
		{
		
		double dist[] = new double[V]; 
		 
        Boolean set[] = new Boolean[V];
        for (int i = 0; i < V; i++)
        {
            dist[i] = Double.MAX_VALUE;
            set[i] = false;
        }
 
        dist[src] = 0;
 
        for (int count = 0; count < V-1; count++)
        {

            int u = minDistance(dist, set);
 
            set[u] = true;
     
            for (int v = 0; v < V; v++) 
            {
            	try {
                if (!set[v] && graph[u][v]!=0 && dist[u] != Double.MAX_VALUE && dist[u]+graph[u][v] < dist[v]) 
                {
                    dist[v] = dist[u] + graph[u][v];
                }
                }catch(NullPointerException e)
        		{
        			errorCheck = -1;
        		}
            }
        }
        
        for(int i=0; i<dist.length; i++) 
        {
        		if(dist[i]>longest) 
        		{
        			longest = dist[i];	 	
        		}
        }
        
		}
	}

	
	/**
	 * @return int: minimum minutes that will pass before the three contestants can meet
	 */
	public int timeRequiredforCompetition()
	{
		int slowest = Math.min(sC,Math.min(sA, sB));

		if(longest == 0 || slowest <=0)
		{
			return -1;
		}
		
		int result = (int)Math.ceil(((longest*1000)/slowest));
		
		if (result == MAX_ERROR)
		{
			return -1;
		}
		
		return result;
	}
	
	
	
	 static int minDistance(double dist[], Boolean set[])
	    {
	        double min = Double.MAX_VALUE; 
	        
	        int minIndex=-1;
	 
	        for (int v = 0; v < V; v++) 
	        {
	            if (set[v] == false && dist[v] <= min)
	            {
	                min = dist[v];
	                minIndex = v;
	            }
	        }
	        return minIndex;
	    }

}


