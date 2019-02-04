package threadingsemaphores;

public class multiThreadMerge {
	
	
	int[][] list;
	int threads = 0;
	MyThread[] lt;
	int[] finalSorted;
	int logn;
	
	multiThreadMerge(int[][] list) 
	{
		this.list = list;
		this.logn = (int) (Math.log(list.length) / Math.log(2));
		
		int count=1;
		for(int i=0; i<logn; i++)
		{
			this.threads+= count;
			count = count*2;
		}
		lt = new MyThread[threads];
		
		//introduction();
		doit();
		
	}
	
	private void introduction()
	{
		System.out.println("We will be merging the following sorted arrays");
		
		for(int i=1; i<=list.length;i++)
		{
			System.out.print(i+": ");
			for(int x=0; x<list[i-1].length;x++)
			{
				System.out.print(" "+list[i-1][x]);
			}
			System.out.println();
		}
		System.out.println();
		
	}
	
	private void doit() 
	{
		System.out.println("............Begining merges............");
		System.out.println();
		
		//go through each level of tree till root
		for(int i=0; i <= logn; i++)
		{
			if(i == logn)
			{
				//done
				//print it out or something....
				this.finalSorted = list[0];
				System.out.println("We are done merging!");
				printArray(finalSorted);
				System.out.println("DONE");
			}
			else
			{
				System.out.println("Parallel Merging stage:"+(i+1));
				double exp = (logn-i)*Math.log10(2);
				int nodes = (int) Math.round( Math.pow(10,exp));
				int sorts = (int)nodes/2;
				
				//Merge first stage
				for(int m=0; m<sorts; m++)
				{
					lt[m] = new MyThread(list[m*2],list[(m*2+1)]);
					lt[m].start();
				}
				
				
				//wait for threads to finish
				for(int m=0; m<sorts; m++)
				{
					try {
						lt[m].join();
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//update list
				list = new int[sorts][];
				for(int x=0; x<sorts; x++)
				{
					list[x] = lt[x].sorted; //this could allow me to reuse my list.
					System.out.println(x+": ");
					printArray(list[x]);
				}
				System.out.println();
				
				
				
			}//end for loop
			
		}
		
		
		/*
		MyThread mt1 = new MyThread(list[0],list[1]);
		mt1.start();
		MyThread mt2 = new MyThread(list[2],list[3]);
		mt2.start();
		try {
			mt1.join(); //ensures theyre done before proceeding
			mt2.join(); //ensures they're done before proceeding
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//go up one level.. in this case root
		MyThread mt3 = new MyThread(mt1.sorted,mt2.sorted);
		mt3.start();
		try {
			mt3.join(); //ensures theyre done before proceeding
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finalSorted = mt3.sorted;
		
		printArray(finalSorted);
		*/
	}
	
	
	public void printArray(int [] a)
	{
		for(int i=0; i<a.length; i++)
		{
			if(i%25 == 0)
			{
				System.out.println();
			}
			System.out.print(" "+a[i]);
		}
		System.out.println("");
		System.out.println("");
	}
	
	

}
