package threadingsemaphores;

import java.util.concurrent.Semaphore;

public class MyThread extends Thread{

	int[] a;
	int[] b;
	int[] sorted;
    
    
    public MyThread(int[] a, int[] b)  
    { 
      this.a = a;
      this.b = b;
    } 
    
    
    public void run()
    {
    		sorted = merge.merge(a,b);
			//Thread.sleep(1);
    }
}
