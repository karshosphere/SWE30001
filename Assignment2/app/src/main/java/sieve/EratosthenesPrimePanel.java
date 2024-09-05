/*
 *	SWE30001, Problem Set 2, 2024
 *
 *	Multi-threaded Sieve of Eratosthenes
 * 
 */

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
        // to assist formatting
		FlashingNumberCanvas.DefaultMaxValue = 100;		
	}
	
	public EratosthenesPrimePanel( int aRowCount, int aColumnCount )
	{
		fRowCount = aRowCount;
		fColumnCount = aColumnCount;
		fNumbers = new FlashingNumberCanvas[fRowCount][fColumnCount];

		setLayout( new GridBagLayout() );
		
		GridBagConstraints lConstraints = new GridBagConstraints();
		lConstraints.insets = new Insets( 5, 5, 5, 5 );
		
		
		// Set array values
		for ( int i = 0; i < fNumbers.length; i++ )
		{
			for ( int j = 0; j < fNumbers[i].length; j++ )
			{
				lConstraints.gridy = i;
				lConstraints.gridx = j;

				FlashingNumberCanvas numberCanvas = new FlashingNumberCanvas( (i+1) + (j*10) );
				numberCanvas.setBackground( Color.cyan );
				fNumbers[i][j] = numberCanvas;
				add( numberCanvas, lConstraints );
			}
		}
	}
	
	private FlashingNumberCanvas getNumberCanvas( int aNumber )
	{
		// auxiliary function to find and return the object in fNumbers
		// that corresponds to aNumber
		
		// decrement aNumber
		aNumber--;
		// Use decremented number to find correct row and column
		return fNumbers[aNumber % fRowCount][aNumber / fColumnCount];
	}

	// interface methods
	@Override public void flash(int aPrime)
    {
		// flash a number canvas when it is being used for division
		FlashingNumberCanvas numberCanvas = getNumberCanvas( aPrime );

		// Change color
		numberCanvas.flash();
		
		synchronized ( this )
    	{
        	try 
        	{
        		wait(10);
        	}
        	catch ( InterruptedException e ) 
        	{}    		
    	}
	}

	@Override public void setAsProcessed( int aNumber )
    {
		// Visually change number canvas to indicate that it has been processed
		FlashingNumberCanvas numberCanvas = getNumberCanvas( aNumber );

		// Change color
		numberCanvas.setBackground( Color.gray );
		numberCanvas.setForeground( Color.black );
	}

	@Override public void setAsAdded( int aNumber )
    {
		// Show number canvas as ready to be processed
		FlashingNumberCanvas numberCanvas = getNumberCanvas( aNumber );
		// Change color
		numberCanvas.setBackground( Color.yellow );
	}

	@Override public void setAsPrime( int aNumber )
    {
		// Visually set a number canvas as prime
		FlashingNumberCanvas numberCanvas = getNumberCanvas( aNumber );
		// Change color
		numberCanvas.setBackground( Color.green );
		numberCanvas.setForeground( Color.red );
	}

	@Override public void reset()
    {
		// Reset all numbers
		
		for ( int i = 0; i < fNumbers.length; i++ )
		{
			for ( int j = 0; j < fNumbers[i].length; j++ )
			{
				FlashingNumberCanvas numberCanvas = fNumbers[i][j];

				// reset colors
				numberCanvas.setBackground( Color.cyan );
				numberCanvas.setForeground( Color.black );
				
				fNumbers[i][j] = numberCanvas;
			}
		}
		
	}	
}
