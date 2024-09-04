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
	
	public PrimePanel( int aRowCount, int aColumnCount )
	{
		// create a panel with GridBagLayout
		// set instance variables
		// use insets of 5, 5, 5, 5
		// initialize array
		// add FlashingNumberCanvas elements to the panel (an array) 
		// initially their background should be CYAN
		// layout numbers by columns
	}
	
	private FlashingNumberCanvas getNumberCanvas( int aNumber )
	{
		// auxiliary function to find and return the object in fNumbers
		// that corresponds to aNumber
	}

	// interface methods
	
	////////////////////////////////////////////
	// some methods may require synchronization
	////////////////////////////////////////////
}
