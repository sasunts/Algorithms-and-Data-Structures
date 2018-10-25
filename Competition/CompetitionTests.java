import org.junit.Test;
import static org.junit.Assert.assertEquals;

/*
 * 1.Justify the choice of the data structures used in CompetitionDijkstra and
 * CompetitionFloydWarshall
 * 
 * For Dijkstra's approach I used a 2D array to store the graph and a 1D array to store the distances.
 * For FW approach, I used a 2D array to again store the graph and a 2D array to store shortest paths distances.
 * 
 * 
 * 2. Explain theoretical differences in the performance of Dijkstra and Floyd-Warshall algorithms
 * in the given problem. Also explain how would their relative performance be affected by the
 * density of the graph. Which would you choose in which set of circumstances and why? 
 * 
 * Dijkstras algorithm is made for a node to node approach hence why the algorithm is put into a loop to find shortest path from 
 * all nodes to all nodes. Compared to FW algorithm it checks for all pairs and creates the shortest path values. Performance wise
 * Dijkstras struggles as our competition that we set up requires Every source(node) to be checked hence why FW approach is more 
 * quicker at giving results especially if you are testing larger arrays as FW looks for the shortest path for every node and the algorithm
 * does not need to be looped multiple times.
 * 
 * 
 * 
 */

public class CompetitionTests {
	
    @Test
    public void testDijkstraConstructor() 
    {
    	CompetitionDijkstra t = new CompetitionDijkstra("input-D.txt",50,80,60);
    	int time = t.timeRequiredforCompetition();
    	assertEquals(time,38);
    }
    
//    @Test
//    public void testDijkstraFileNotFound() 
//    {
//    	CompetitionDijkstra t = new CompetitionDijkstra("inp.txt",50,80,60);
//    	int time = t.timeRequiredforCompetition();
//    	assertEquals(time,-1);
//    }
    
//    @Test
//    public void testDijkstraFileNameError() 
//    {
//    	CompetitionDijkstra t = new CompetitionDijkstra("",50,80,60);
//    	int time = t.timeRequiredforCompetition();
//    	assertEquals(time,-1);
//    }
    
//    @Test
//    public void testDijkstraFileNameNull() 
//    {
//    	CompetitionDijkstra t = new CompetitionDijkstra(null,50,80,60);
//    	int time = t.timeRequiredforCompetition();
//    	assertEquals(time,-1);
//    }
    
    @Test
    public void testDijkstraSpeed() 
    {
    	CompetitionDijkstra t = new CompetitionDijkstra("tinyEWD.txt",0,0,0);
    	int time = t.timeRequiredforCompetition();
    	assertEquals(time,-1);
    }

    @Test
    public void testFWConstructor() 
    {
    	CompetitionFloydWarshall a = new CompetitionFloydWarshall("input-D.txt",50,80,60);
		int time = a.timeRequiredforCompetition();
		assertEquals(time,38);
    }
    
    @Test
    public void testFWFileNotFound() 
    {
    	CompetitionFloydWarshall a = new CompetitionFloydWarshall("inp.txt",50,80,60);
		int time = a.timeRequiredforCompetition();
		assertEquals(time,-1);
    }
    
    @Test
    public void testFWFileNameError() 
    {
    	CompetitionFloydWarshall a = new CompetitionFloydWarshall("",50,80,60);
		int time = a.timeRequiredforCompetition();
		assertEquals(time,-1);
    }
    
    @Test
    public void testFWFileNameNull() 
    {
    	CompetitionFloydWarshall a = new CompetitionFloydWarshall(null,50,80,60);
		int time = a.timeRequiredforCompetition();
		assertEquals(time,-1);
    }
    
    @Test
    public void testFWSpeed() 
    {
    	CompetitionFloydWarshall a = new CompetitionFloydWarshall("tinyEWD.txt",0,0,0);
		int time = a.timeRequiredforCompetition();
		assertEquals(time,-1);
    }
    
}
