
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
        //
        // grid baground layout

        setLayout( new GridBagLayout() );

        // initialise number generator
        fSieve = aSieve;
        fGenerator = new NumberGenerator( aLimit, fSieve );
        
        // constraints
        GridBagConstraints lConstraints = new GridBagConstraints();
        lConstraints.fill = GridBagConstraints.VERTICAL;
        lConstraints.insets = new Insets( 20, 5, 20, 5 );

        //
        // score board

        fActive = new TitledNumberCanvas( "Active", 150, 150 );
        fActive.setBackground( Color.LIGHT_GRAY );
        lConstraints.gridy = 0;
        add( fActive, lConstraints );

        fThreads = new TitledNumberCanvas( "Threads", 150, 150 );
        fThreads.setBackground( Color.LIGHT_GRAY );
        lConstraints.gridy = 1;
        add( fThreads, lConstraints );

        fNumbersTested = new TitledNumberCanvas( "Tested", 150, 150 );
        fNumbersTested.setBackground( Color.LIGHT_GRAY );
        lConstraints.gridy = 2;
        add( fNumbersTested, lConstraints );

        fPrimesFound = new TitledNumberCanvas( "Primes", 150, 150 );
        fPrimesFound.setBackground( Color.LIGHT_GRAY );
        lConstraints.gridy = 3;
        add( fPrimesFound, lConstraints );

        //
        // go button

        Dimension lButtonDimension = new Dimension( 150, 75 );
        fGo = MakeButton.createButton( "Go", e -> go(), lButtonDimension );
        lConstraints.gridy = 4;
        add( fGo, lConstraints );
    }

    @Override public int getFiltered()
    {
        return fNumbersTested.getValue();
    }

    @Override public int getThreads()
    {
        return fThreads.getValue();
    }

    @Override public void incrementActive()
    {
        fActive.setValue( fActive.getValue() + 1 );
        synchronized ( this )
        {
            try { wait( 10 ); }
            catch ( InterruptedException e ) {}
        }
    }

    @Override public void decrementActive()
    {
        fActive.setValue( fActive.getValue() - 1 );
        synchronized ( this )
        {
            try { wait( 10 ); }
            catch ( InterruptedException e ) {}
        }
    }

    @Override public void incrementThreads()
    {
        fThreads.setValue( fThreads.getValue() + 1 );
        synchronized ( this )
        {
            try { wait( 10 ); }
            catch ( InterruptedException e ) {}
        }
    }

    @Override public void decrementThreads()
    {
        fThreads.setValue( fThreads.getValue() - 1 );
        synchronized ( this )
        {
            try { wait( 10 ); }
            catch ( InterruptedException e ) {}
        }
    }

    @Override public void incrementFiltered()
    {
        fNumbersTested.setValue( fNumbersTested.getValue() + 1 );
        synchronized ( this )
        {
            try { wait( 10 ); }
            catch ( InterruptedException e ) {}
        }
    }

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

    @Override public void enableControl()
    {
        setEnabled( true );
    }

    @Override public void reset()
    {
        fActive.setValue( 0 );
        fThreads.setValue( 0 );
        fGo.setEnabled( true );
    }
}

