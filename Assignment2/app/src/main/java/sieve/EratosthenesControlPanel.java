
package sieve;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.swin.rt.MakeButton;
import edu.swin.rt.TitledNumberCanvas;

public class EratosthenesControlPanel extends JPanel implements IControl
{
    private static final long serialVersionUID = 1L;

    private ISieve fSieve;
    private TitledNumberCanvas fActive;
    private TitledNumberCanvas fThreads;
    private TitledNumberCanvas fPrimesFound;
    private TitledNumberCanvas fNumbersTested;
    private JButton fGo;

    private NumberGenerator fGenerator;

    private void go()
    {
        // reset all values
        fSieve.reset();
        fPrimesFound.setValue( 0 );
        fNumbersTested.setValue( 0 );

        fGo.setEnabled( false ); // disable go
        fGenerator.start();      // start number generator
    }

    public EratosthenesControlPanel( int aLimit, ISieve aSieve )
    {
        // grid baground layout
        setLayout( new GridBagLayout() );

        // initialise number generator
        fSieve = aSieve;
        fGenerator = new NumberGenerator( aLimit, fSieve );
        
        // constraints
        GridBagConstraints lConstraints = new GridBagConstraints();
        lConstraints.fill = GridBagConstraints.VERTICAL;
        lConstraints.insets = new Insets( 20, 5, 20, 5 );

        // score board: active count
        lConstraints.gridy = 0;
        fActive = new TitledNumberCanvas( "Active", 150, 150 );
        fActive.setBackground( Color.LIGHT_GRAY );
        add( fActive, lConstraints );

        // score board: threads count
        lConstraints.gridy = 1;
        fThreads = new TitledNumberCanvas( "Threads", 150, 150 );
        fThreads.setBackground( Color.LIGHT_GRAY );
        add( fThreads, lConstraints );

        // score board: tested count
        lConstraints.gridy = 2;
        fNumbersTested = new TitledNumberCanvas( "Tested", 150, 150 );
        fNumbersTested.setBackground( Color.LIGHT_GRAY );
        add( fNumbersTested, lConstraints );

        // score board: prime count
        lConstraints.gridy = 3;
        fPrimesFound = new TitledNumberCanvas( "Primes", 150, 150 );
        fPrimesFound.setBackground( Color.LIGHT_GRAY );
        add( fPrimesFound, lConstraints );

        // score board: start (go) button
        lConstraints.gridy = 4;
        fGo = MakeButton.createButton(
            "Go", e -> go(),
            new Dimension( 150, 75 )
        );
        add( fGo, lConstraints );
    }

    // return current number of filtered (tested) numbers
    @Override public int getFiltered()
    {
        return fNumbersTested.getValue();
    }

    // return current number of active threads
    @Override public int getThreads()
    {
        return fThreads.getValue();
    }

    // increments active thread count
    // a small wait for synchronisation
    @Override public void incrementActive()
    {
        fActive.setValue( fActive.getValue() + 1 );
        synchronized ( this )
        {
            try { wait( 10 ); }
            catch ( InterruptedException e ) {}
        }
    }

    // decrements active thread count
    // a small wait for synchronisation
    @Override public void decrementActive()
    {
        fActive.setValue( fActive.getValue() - 1 );
        synchronized ( this )
        {
            try { wait( 10 ); }
            catch ( InterruptedException e ) {}
        }
    }

    // increments thread count
    // a small wait for synchronisation
    @Override public void incrementThreads()
    {
        fThreads.setValue( fThreads.getValue() + 1 );
        synchronized ( this )
        {
            try { wait( 10 ); }
            catch ( InterruptedException e ) {}
        }
    }

    // decrements thread count
    // a small wait for synchronisation
    @Override public void decrementThreads()
    {
        fThreads.setValue( fThreads.getValue() - 1 );
        synchronized ( this )
        {
            try { wait( 10 ); }
            catch ( InterruptedException e ) {}
        }
    }

    // increments count of tested numbers
    // a small wait for synchronisation
    @Override public void incrementFiltered()
    {
        fNumbersTested.setValue( fNumbersTested.getValue() + 1 );
        synchronized ( this )
        {
            try { wait( 10 ); }
            catch ( InterruptedException e ) {}
        }
    }

    // increments count of found primes and tested numbers
    // a small wait for synchronisation
    @Override public void incrementPrimes()
    {
        fPrimesFound.setValue( fPrimesFound.getValue() + 1 );
        incrementFiltered();

        synchronized ( this )
        {
            try { wait( 10 ); }
            catch ( InterruptedException e ) {}
        }
    }

    // enables control components (buttons)
    @Override public void enableControl()
    {
        setEnabled( true );
    }

    // resets active and thread counters and enables Go button
    @Override public void reset()
    {
        fActive.setValue( 0 );
        fThreads.setValue( 0 );
        fGo.setEnabled( true );
    }
}

