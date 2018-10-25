
public class KMPSearch {

	/*
	 * Bus Service Questions:
	 *
	 * 1. How many total vehicles is there information on?
	 *    987
	 *
	 * 2. Does the file contain information about the vehicle number 16555?
	 *    yes
	 *
	 * 3. Locate the first record about a bus heading to HAMPTON PARK
	 *    19774
	 *
	 * 4. Does the file contain information about the vehicle number 9043409?
	 *    no
	 */

	/*
	 * The method checks whether a pattern pat occurs at least once in String txt.
	 *
	 */
	
	private static int[][] dfa; 
	private final static int R = 256; 
	
	public static void dfa(String pat)
	{
		int m = pat.length();
		dfa = new int[R][m];
		dfa[pat.charAt(0)][0] = 1;
		for (int x = 0, j = 1; j < m; j++)
		{
			for (int c = 0; c < R; c++) 
			{
				dfa[c][j] = dfa[c][x];
			}
			dfa[pat.charAt(j)][j] = j + 1; 
			x = dfa[pat.charAt(j)][x];
		}
	}
	
	public static boolean contains(String txt, String pat) 
	{

		if (pat.equals("")||pat == null) {
			return false;
		}
		if(txt.equals("") || txt == null)
		{
			return false;
		}

		dfa(pat);

		int i; 
		int j;
		int n = txt.length();
		int m = pat.length();
		for (i = 0, j = 0; i < n && j < m; i++) 
		{
			j = dfa[txt.charAt(i)][j];
		}
		if (j == m)
		{
			return true;
		}
		return false;
	}

	/*
	 * The method returns the index of the first ocurrence of a pattern pat in String txt.
	 * It should return -1 if the pat is not present
	 */
	public static int searchFirst(String txt, String pat) 
	{

		if(pat.equals("")||txt.equals(""))
		{
			return -1;
		}

		dfa(pat);

		int i; 
		int j;
		int n = txt.length();
		int m = pat.length();
		for (i = 0, j = 0; i < n && j < m; i++) 
		{
			j = dfa[txt.charAt(i)][j];
		}
		if (j == m)
		{
			return i - m;
		}
		return -1;
	}

	/*
	 * The method returns the number of non-overlapping occurences of a pattern pat in String txt.
	 */
	public static int searchAll(String txt, String pat) 
	{

		if(pat == "")
		{
			return 0;
		}

		dfa(pat);

		int noOverlapCount = 0;
		int i; 
		int j;
		int n = txt.length();
		int m = pat.length();
		for (i = 0, j = 0; i < n && j < m; i++) 
		
		{
			j = dfa[txt.charAt(i)][j];
			if (j == m) 
			{
				noOverlapCount++;
				j = 0;
			}
		}
		return noOverlapCount;
	}
	
}
