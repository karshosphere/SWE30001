
package sieve;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import edu.swin.rt.FlashingNumberCanvas;

public class EratosthenesPrimePanel extends JPanel implements IPrimes
{
    private static final long serialVersionUID = 1L;

    private int fRowCount;
    private int fColumnCount;

    private FlashingNumberCanvas fNumbers[][];

    static
    {
        FlashingNumberCanvas.DefaultMaxValue = 100;		
    }

    public EratosthenesPrimePanel( int aRowCount, int aColumnCount ) {
        // initialize row and column
        fRowCount = aRowCount;
        fColumnCount = aColumnCount;

        // 2D array to hold FlashingNumberCanvas objects
        fNumbers = new FlashingNumberCanvas[fRowCount][fColumnCount];

        // layout manager to GridBagLayout
        setLayout( new GridBagLayout() );

        // to control how each number canvas is placed within the grid
        GridBagConstraints lConstraints = new GridBagConstraints();
        lConstraints.insets = new Insets(5, 5, 5, 5); // add spacing

        // initialise and place each FlashingNumberCanvas in the grid
        for ( int i = 0; i < fNumbers.length; i++ ) {
            for ( int j = 0; j < fNumbers[i].length; j++ ) { 
                                                           
                lConstraints.gridy = i; // row position
                lConstraints.gridx = j; // column position

                // new FlashingNumberCanvas
                FlashingNumberCanvas numberCanvas = new FlashingNumberCanvas(
                    ( i + 1 ) + ( j * 10 )
                );

                // set background to cyan
                numberCanvas.setBackground( Color.cyan );

                // store FlashingNumberCanvas in the 2D array
                fNumbers[i][j] = numberCanvas;

                // add FlashingNumberCanvas to panel using the grid constraints
                add(numberCanvas, lConstraints);
            }
        }
    }

    // auxiliary function to find and return the object in fNumbers
    private FlashingNumberCanvas getNumberCanvas( int aNumber )
    {
        aNumber--;
        return fNumbers[aNumber % fRowCount][aNumber / fColumnCount];
    }

    // auxiliary function to find and return the object in fNumbers
    @Override public void flash(int aPrime)
    {
        FlashingNumberCanvas numberCanvas = getNumberCanvas( aPrime );
        numberCanvas.flash();

        synchronized ( this )
        {
            try { wait(10); }
            catch ( InterruptedException e ) {}    		
        }
    }

    @Override public void setAsProcessed( int aNumber )
    {
        // visually change number canvas to indicate that it has been processed
        FlashingNumberCanvas numberCanvas = getNumberCanvas( aNumber );

        numberCanvas.setBackground( Color.gray );
        numberCanvas.setForeground( Color.black );
    }

    // show number canvas as ready to be processed
    @Override public void setAsAdded( int aNumber )
    {
        FlashingNumberCanvas numberCanvas = getNumberCanvas( aNumber );
        numberCanvas.setBackground( Color.yellow );
    }

    // visually set a number canvas as prime
    @Override public void setAsPrime( int aNumber )
    {
        FlashingNumberCanvas numberCanvas = getNumberCanvas( aNumber );
        numberCanvas.setBackground( Color.green );
        numberCanvas.setForeground( Color.red );
    }

    // reset all numbers
    @Override public void reset()
    {
        for ( int i = 0; i < fNumbers.length; i++ )
        {
            for ( int j = 0; j < fNumbers[i].length; j++ )
            {
                FlashingNumberCanvas numberCanvas = fNumbers[i][j];

                // reset colors ( set back to default )
                numberCanvas.setBackground( Color.cyan );
                numberCanvas.setForeground( Color.black );

                fNumbers[i][j] = numberCanvas;
            }
        }
    }	
}

