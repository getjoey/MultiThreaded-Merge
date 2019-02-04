package threadingsemaphores;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[][] list = createRandomArrayList(64,10); // 8arrays of 4ints
		
	
		
		System.out.println("Starting multi Threaded merge");
		multiThreadMerge m = new multiThreadMerge(list);
		
		
		//Note; Console printout limits 25 numbers per line else it might not show due to length
	
	}
	
	static int[] random(int size)
	{
		Random ran = new Random();
		
		int[] rs = new int[size];
		
		for(int i=0; i<rs.length; i++)
		{
			int x = ran.nextInt(50+i*10);
			
			if(i==0)
			{
				rs[i] = x;
			}
			else
			{
				while( x < rs[i-1])
				{
					x = ran.nextInt(50+i*10);
				}
				rs[i] = x;
			}
			
			
		
		}
		
		return rs;
	}
	
	static int[][] createRandomArrayList(int listSize, int arraySize)
	{
		int[][] list = new int[listSize][];
		
		for(int i=0; i< listSize; i++)
		{
			int[] r = random(arraySize);
			list[i] = r;
		}
		
		
		return list;
	}
	
	static void printArray(int [] a)
	{
		for(int i=0; i<a.length; i++)
		{
			System.out.print(" "+a[i]);
		}
		System.out.println("");
	}
	

}
