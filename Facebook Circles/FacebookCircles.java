/**
 * Class FacebookCircles: calculates the statistics about the friendship circles in facebook data.
 *
 * @author Vahe Sasunts
 *
 * @version 06/12/17 02:03:28
 */
public class FacebookCircles {

	private int numberOfFacebookUsers;
	private int[] userID;
	private int numberOfCircles;   	 
	private int sizeOfLargestCircle;
	private int[] size;	

	/**
	 * Constructor
	 * @param numberOfFacebookUsers : the number of users in the sample data.
	 * Each user will be represented with an integer id from 0 to numberOfFacebookUsers-1.
	 */
	public FacebookCircles(int numberOfFacebookUsers) {
		this.numberOfFacebookUsers = numberOfFacebookUsers;
		numberOfCircles=numberOfFacebookUsers;
		userID = new int[numberOfFacebookUsers];
		for(int i =0; i<numberOfFacebookUsers;i++)
		{
			userID[i] = i;
		}  

		size = new int [numberOfFacebookUsers];
		for (int i=0; i < size.length; i++) 
		{
			size[i] = 1;
		}
		sizeOfLargestCircle = 1;
	}


	/**
	 * creates a friendship connection between two users, represented by their corresponding integer ids.
	 * @param user1 : int id of first user
	 * @param user2 : int id of second  user
	 */
	public void friends( int user1, int user2 ) 
	{
		int i = user1;
		while (i != userID[i]) 
		{
			userID[i] = userID[userID[i]];
			i = userID[i];
		}
		int j = user2;
		while (j != userID[j]) 
		{
			userID[j] = userID[userID[j]];
			j = userID[j];
		}

		if (i == j) 
		{ 
			return;
		}
		numberOfCircles--;
		if (size[i] < size[j]) 
		{ 
			userID[i] = j; 
			size[j] += size[i]; 
			if (size[j] > sizeOfLargestCircle)
			{
				sizeOfLargestCircle = size[j];
			}
		}
		else 
		{ 
			userID[j] = i; 
			size[i] += size[j];
			if (size[i] > sizeOfLargestCircle) 
			{
				sizeOfLargestCircle = size[i];
			}
		} 
		return;
	}

	/**
	 * @return the number of friend circles in the data already loaded.
	 */
	public int numberOfCircles() 
	{
		return numberOfCircles;
	}

	/**
	 * @return the size of the largest circle in the data already loaded.
	 */
	public int sizeOfLargestCircle() 
	{
		return sizeOfLargestCircle;
	}

	/**
	 * @return the size of the median circle in the data already loaded.
	 */
	public int sizeOfAverageCircle() 
	{
		int all = 0;
		int devisor = numberOfCircles();
		
		for (int i = 0; i < numberOfFacebookUsers; i++) 
		{
			if (userID[i] == i) 
			{			
				all+= size[i];
			}
		}
		int median = (all/devisor);
		return median;
	}

	/**
	 * @return the size of the smallest circle in the data already loaded.
	 */
	public int sizeOfSmallestCircle() 
	{
		int smallestCircle = Integer.MAX_VALUE;
	    for (int i = 0; i < numberOfFacebookUsers; i++) 
	    {
	    	if (userID[i] == i && size[i]<smallestCircle) 
	    	{			
	    		smallestCircle = size[i];
	    	}
	    }
	    return smallestCircle;
	}
}
