/*
 *	SWE30001, 2024
 *
 *	Multi-threaded Sieve of Eratosthenes
 * 
 */

package sieve;

public class Sieve implements ISieve
{
    private int fThreadCount;				// number of thread running
    private int fPrimeCount;				// number of primes found
    private int fFiltered;					// number of integers filtered
	
    private NumberGenerator fGenerator;		// integer generator

    private void println( String aFormat, Object... args )
    {
      String lFormat = String.format( "%s: %s", 
    		                          Thread.currentThread().getName(),
    		                          aFormat );
    			
      System.out.println( String.format( lFormat, args ) );
    }
    
    public Sieve()
    {
    	// constructor for Sieve    	
	}
    
    public synchronized int getFiltered()
    {
    	// get number of filtered integers
    }

    public synchronized int getThreads()
    {
		// get number of active threads
    }
    
	public void scheduled( int aNumber )
    {
    	// prints thread name and number being tested
    }
		
    public void flash( int aPrime, int aNumberTested )
    {
    	// prints thread name and number being tested
    	// waits for 200 ms
    }

    public synchronized void incrementThreads( int aPrime )
    {
    	// increments thread count
    	// prints Thread name, thread count, and prime if prime != 0
    	// otherwise, just prints thread name and thread count
    }

    public synchronized void decrementThreads()
    {
    	// decrements thread count
    	// prints Thread name and thread count
    }

    public synchronized void incrementFiltered( int aNumberTested )
    {
    	// increments filtered count
    	// prints Thread name and integer filtered
    }

    public synchronized void incrementPrimes( int aPrime )
    {
		// increments filtered count
    	// increments prime count
    	// prints Thread name, prime, and prime count
    }
	
    public void finished()
	{
		// prints "Test completed." and the number of primes found
	}
    
    public void reset()
	{
	    // reset sieve
	}
	
    public void execute()
    {
    	// creates generator for 100 integers
    	// starts generator
    	// waits 1ms (in loop) until thread count is zero, requires synchronization
    }
	
    public static void main( String[] args )
    {
    	(new Sieve()).execute();
    }
}
