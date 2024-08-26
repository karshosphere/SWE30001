/*
 *	SWE30001, 2024
 *
 * 	Car simulator Main window (Java JFrame)
 * 
 *  Code based on CruiseControl, Concurrency: State Models & Java Programs
 * 
 */

package cruise;

import java.awt.GridLayout;

import edu.swin.rt.ApplicationFrame;

public class SimulatorFrame extends ApplicationFrame 
{
	private static final long serialVersionUID = 1L;
	
	CarSimulatorController fCarSimulator;
	CruiseControlController fCruiseControlSimulator;

    public SimulatorFrame( String aTitle )
    {
    	super( aTitle );

        getContentPane().setLayout( new GridLayout( 1, 2, 1, 1 ) );

        fCarSimulator = new CarSimulatorController();
        fCruiseControlSimulator = new CruiseControlController( fCarSimulator );
        
        getContentPane().add( fCarSimulator );
        getContentPane().add( fCruiseControlSimulator );

        pack();
    }
}
