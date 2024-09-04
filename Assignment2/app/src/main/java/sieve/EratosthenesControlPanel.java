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
		// start Sieve, clear all values, disable Go, start generator
	}

	public ControlPanel( int aLimit, ISieve aSieve )
	{
		// create a panel with GridBagLayout 
		// initialize instance variables
		// create number generator
		// use insets 20, 5, 20, 5
		// create TitledNumberCanvas control and add them to panel 
		// add Go button and link ActionListener of Go button to go() method
	}
	
	// interface methods

	////////////////////////////////////////////
	// some methods may require synchronization
	////////////////////////////////////////////	
}
