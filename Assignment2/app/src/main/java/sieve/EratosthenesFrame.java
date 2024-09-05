
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

    public EratosthenesFrame( String aTitle )
    {
        super( aTitle );

        getContentPane().setLayout( new GridBagLayout() );
        GridBagConstraints lConstraints = new GridBagConstraints();

        lConstraints.fill = GridBagConstraints.HORIZONTAL;
        lConstraints.insets = new Insets( 5, 5, 5, 5 );

        fPrimes = new EratosthenesPrimePanel(
            Eratosthenes.ROWS, Eratosthenes.COLUMNS
        );
        getContentPane().add( fPrimes, lConstraints );

        fControls = new EratosthenesControlPanel( Eratosthenes.TESTS, this );
        getContentPane().add( fControls, lConstraints );

        pack();
    }

    @Override public int getFiltered()
    {
        return fControls.getFiltered();
    }

    @Override public int getThreads()
    {
        return fControls.getThreads();
    }

    @Override public void scheduled( int aNumber )
    {
        fPrimes.setAsAdded( aNumber );
    }

    @Override public void flash( int aPrime, int aNumberTested )
    {
        fPrimes.flash( aPrime );
        fPrimes.flash( aNumberTested );
    }

    @Override public void incrementActive()
    {
        fControls.incrementActive();
    }

    @Override public void decrementActive()
    {
        fControls.decrementActive();
    }

    @Override public void incrementThreads( int aPrime )
    {
        fControls.incrementThreads();
    }

    @Override public void decrementThreads()
    {
        fControls.decrementThreads();
    }

    @Override public void incrementFiltered( int aNumberTested )
    {
        fPrimes.setAsProcessed( aNumberTested );
        fControls.incrementFiltered();
    }

    @Override public void incrementPrimes( int aPrime )
    {
        fPrimes.setAsPrime( aPrime );
        fControls.incrementPrimes();
    }

    @Override public void finished()
    {
        fControls.reset();
    }

    @Override public void reset()
    {
        fPrimes.reset();
        fControls.reset();
    }
}

