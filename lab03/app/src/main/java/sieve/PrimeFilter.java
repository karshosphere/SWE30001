/*
 *	SWE30001, 2024
 *
 *	Multi-threaded Sieve of Eratosthenes
 * 
 */

package sieve;

public class PrimeFilter implements Runnable
{
    private int fPrime;					// the prime number of this filter
    private ISieve fSieve;				// reference to Sieve
    private PrimeFilter fNextPrime;		// next prime filter

    private Thread fThread;				// this prime filter’s thread
    private int fTest;					// integer to be tested
	
    public PrimeFilter( int aPrime, ISieve aSieve )
    {
    	// constructor
    	// initially fTest is set to -1 signaling that no number is available
    }
	
    public void start()
    {
    	// create and start filter thread, name it Filter x, where x is the fPrime
    }
	
    public void stop()
    {
    	// if next filter is not null, stop it
    	// if this thread is not null, interrupt it
    }
	
    public synchronized void filter( int aTest )
    {
    	// set test
    	// notify this filter
    }
	
    public void run()
    {
    	// increment Sieve's thread count for this prime
		// (potential for race condition with NumberGenerator)
		
    	// continuously run a loop that
    	// 1. Tests if a new test number is available, otherwise wait
    	// 2. Using flash of Sieve, signal that this filter is active
    	// 3. If test can be divided by this filter, mark test filtered (use Sieve)
    	// 4. If test cannot be divided, send test to next filter
    	// 5. If no next filter is available, create a new one and signal (to Sieve)
    	//    that a new prime has been discovered, create and start new filter thread
    	//    (potential for race condition with NumberGenerator)
	    // 6. Set fTest to -1 indicating that this filter is done
    	// At the end, signal to Sieve, once this thread is done, to decrement the
    	// thread count by one
	}
}
