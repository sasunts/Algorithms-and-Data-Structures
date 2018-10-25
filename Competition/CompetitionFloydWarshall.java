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
 * This class implements the competition using Floyd-Warshall algorithm
 */

public class CompetitionFloydWarshall {
	public int V;
	public final int MAX_ERROR = 2147483647;
	public int sA;
	public int sB;
	public int sC;
	public String filename;
	public int slowestSpeed;
	public double graph[][];
	public int intersection;
	public double maxDistance;
	public int errorCheck;
	public int time;
	public double dist[][];
	final static int INF = 99999;

	/**
	 * @param filename: A filename containing the details of the city road network
	 * @param sA, sB, sC: speeds for 3 contestants
	 */
	CompetitionFloydWarshall (String filename, int sA, int sB, int sC) 
	{
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
		

		for(int i = 0; i < V; i++) 
		{
			for(int j = 0; j < V; j++) 
			{
				if(i == j) 
				{
					this.graph[i][j] = 0;
				}
				else 
				{
					this.graph[i][j] = INF;
				}
			}
		}

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


		this.dist = new double[V][V];

		int i, j, k;

		for (i = 0; i < V; i++) 
		{
			for (j = 0; j < V; j++)
			{
				dist[i][j] = this.graph[i][j];
			}
		}


		for (k = 0; k < V; k++)
		{
			for (i = 0; i < V; i++)
			{
				for (j = 0; j < V; j++)
				{
					if (dist[i][k] + dist[k][j] < dist[i][j])
					{
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}

		for( i = 0; i < V; i++)
		{
			for( j = 0; j < V; j++)
			{
				if(maxDistance<graph[i][j])
				{
					maxDistance = graph[i][j];
				}
			}
		}


		int minSpeed;
		minSpeed = Math.min(sA, sB);
		minSpeed = Math.min(minSpeed,sC);
		this.slowestSpeed = minSpeed;

		time = (int) ((maxDistance/slowestSpeed) * 1000);
	}


	/**
	 * @return int: minimum minutes that will pass before the three contestants can meet
	 */
	public int timeRequiredforCompetition()
	{
		double longest = 0;
    	int slowest = Math.min(sC,Math.min(sA, sB));
    	
    	for(int i=0;i<dist.length;i++)
    	{
    		for(int j=0;j<dist[i].length;j++)
    		{
    				if(dist[i][j]==INF)
    				{
    					return -1;
    				}
    				else if(dist[i][j]>longest)
    				{
    					longest = dist[i][j];
    				}
    		}
    	}

    	if(longest == 0 || slowest <= 0)
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

}