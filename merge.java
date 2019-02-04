package threadingsemaphores;

public class merge {
	
	
	static int[] merge(int [] a, int[] b)
	{
		int posA = 0;
		int posB = 0;
		int [] sorted = new int[a.length+b.length];
		
		while((posA+posB) < (a.length+b.length-1)) 
		{
			
			if(a[posA] <= b[posB]  && posA < a.length)
			{
				sorted[posA+posB] = a[posA];
				posA++;
			}
			else if (a[posA] > b[posB] && posB < b.length)
			{
				sorted[posA+posB] = b[posB];
				posB++;
			}
			
			
			//add remaining
			if (posA < a.length && posB == b.length)
			{
				while(posA < a.length)
				{
					sorted[posA+posB] = a[posA];
					posA++;
				}
			}
			if (posB < b.length && posA ==a.length)
			{
				while(posB < b.length)
				{
					sorted[posA+posB] = b[posB];
					posB++;
				}
			}
			
		}
		
		return sorted;
	}

}
