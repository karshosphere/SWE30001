/*
 *	SWE30001, 2024
 *
 *	Multi-threaded Sieve of Eratosthenes
 * 
 */

package sieve;

public class NumberGenerator implements Runnable
{
    private int fLimit;			// number of integers to generate
    private ISieve fSieve;		// reference to main object 

    private Thread fThread;		// the NumberGenerator thread
    private PrimeFilter fTwo;	// the first filter for 2
	
    public NumberGenerator( int aLimit, ISieve aSieve )
    {
    	// constructor
    }
	
    public void start()
    {
    	// create "NumberGenerator" thread and start it
    	// signal to Sieve that a thread has been started, use 0 as argument
    }
	
    public void stop()
    {
    	// if fTwo is not null, stop fTwo
    }
	
    public void run()
    {
    	// mark 1 as filtered (Sieve)
    	// mark 2 as filtered and add 2 as prime (Sieve)
    	// create a filter for 2 and start it
    	// while the thread is active, send every 100 ms
    	// the next integer to the fTwo filter
    	// stop at fLimit
    	// wait for 1 ms while the Sieve returns getFiltered() != fLimit
    	// stop the generator
    	// wait for 1 ms while the Sieve returns getThreads() > 1
		// interrupt thread
    	// finally, decrement the Sieve's thread count by one and finish
	}
}
