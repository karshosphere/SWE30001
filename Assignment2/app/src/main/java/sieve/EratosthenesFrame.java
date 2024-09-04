/*
 *	SWE30001, Problem Set 2, 2024
 *
 *	Multi-threaded Sieve of Eratosthenes
 * 
 */

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

		fPrimes = new EratosthenesPrimePanel( Eratosthenes.ROWS, Eratosthenes.COLUMNS );
		getContentPane().add( fPrimes, lConstraints );
		
		fControls = new EratosthenesControlPanel( Eratosthenes.TESTS, this );
		getContentPane().add( fControls, lConstraints );

		pack();
 	}
	
	// interface methods

	////////////////////////////////////////////
	// some methods may require synchronization
	////////////////////////////////////////////	
}
