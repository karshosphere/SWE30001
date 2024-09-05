
package sieve;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import edu.swin.rt.ApplicationFrame;

public class EratosthenesFrame extends ApplicationFrame implements ISieve
{
    private static final long serialVersionUID = 1L;

    private EratosthenesPrimePanel fPrimes;
    private EratosthenesControlPanel fControls;

    public EratosthenesFrame( String aTitle ) {
        super(aTitle);

        // set the layout manager of the frame's content pane to GridBagLayout
        getContentPane().setLayout( new GridBagLayout() );
        GridBagConstraints lConstraints = new GridBagConstraints();

        // allow components to expand horizontally within their grid cell
        lConstraints.fill = GridBagConstraints.HORIZONTAL;
        lConstraints.insets = new Insets( 5, 5, 5, 5 ); // set padding 

        // new instance of EratosthenesPrimePanel
        fPrimes = new EratosthenesPrimePanel(
            Eratosthenes.ROWS, Eratosthenes.COLUMNS
        );
        getContentPane().add( fPrimes, lConstraints );

        // new instance of EratosthenesControlPanel
        // passing in the number of tests and a reference to this frame
        fControls = new EratosthenesControlPanel( Eratosthenes.TESTS, this );
        getContentPane().add( fControls, lConstraints );

        pack();
    }

    // return current number of filtered numbers from control panel
    @Override public int getFiltered()
    {
        return fControls.getFiltered();
    }

    // return current number of active threads from control panel
    @Override public int getThreads()
    {
        return fControls.getThreads();
    }

    // marks given number as added (scheduled for processing) in prime panel
    @Override public void scheduled( int aNumber )
    {
        fPrimes.setAsAdded( aNumber );
    }

    // flashes prime and the number being tested in the prime panel
    @Override public void flash( int aPrime, int aNumberTested )
    {
        fPrimes.flash( aPrime );
        fPrimes.flash( aNumberTested );
    }

    // increments count of active threads in control panel
    @Override public void incrementActive()
    {
        fControls.incrementActive();
    }

    // decrements count of active threads in control panel
    @Override public void decrementActive()
    {
        fControls.decrementActive();
    }

    // increments thread count when a new prime thread is created in control panel
    @Override public void incrementThreads( int aPrime )
    {
        fControls.incrementThreads();
    }

    // decrements thread count when a prime thread finishes in control panel
    @Override public void decrementThreads()
    {
        fControls.decrementThreads();
    }

    // marks tested number as processed and increments filtered count in control
    // panel
    @Override public void incrementFiltered( int aNumberTested )
    {
        fPrimes.setAsProcessed( aNumberTested );
        fControls.incrementFiltered();
    }

    // marks given number as a prime and increments the prime count in control 
    // panel
    @Override public void incrementPrimes( int aPrime )
    {
        fPrimes.setAsPrime( aPrime );
        fControls.incrementPrimes();
    }

    // resets control panel after all numbers have been processed
    @Override public void finished()
    {
        fControls.reset();
    }

    // resets both prime panel and control panel to their initial states
    @Override public void reset()
    {
        fPrimes.reset();
        fControls.reset();
    }
}

