
package Counter;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;


public class CounterFrame extends JFrame
{
	private CounterCanvas fView;    // counter canvas
	private JButton  fIncrement;	// increment button
	private JButton  fDecrement;	// decrement button

	private void updateButtons()	// update buttons
	{
		fIncrement.setEnabled( fView.getValue() < CounterCanvas.MAX );
		fDecrement.setEnabled( fView.getValue() > 0 );
	}

	private void increment()		// increment event handler
	{
		fView.increment();
		updateButtons();
	}

	private void decrement()		// decrement event handler
	{
		fView.decrement();
		updateButtons();
	}

	private static final long serialVersionUID = 1L;

	// constructor: set up GUI
	public CounterFrame( String aTitle )
	{
		super( aTitle );

		// make sure we have nice window decorations.
		JFrame.setDefaultLookAndFeelDecorated( true );

		// fixed size
		setResizable( false );

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		// grid back layout: canvas requires two rows
		getContentPane().setLayout( new GridBagLayout() );
		GridBagConstraints lConstraints = new GridBagConstraints();
		lConstraints.fill = GridBagConstraints.HORIZONTAL;

		fView = new CounterCanvas();
		lConstraints.gridx = 0;
		lConstraints.gridy = 0;
		lConstraints.gridwidth = 2; // occupy 2 rows

		getContentPane().add( fView, lConstraints );

		fIncrement = new JButton( "Inc" );
		fIncrement.addActionListener( e -> increment() );
		lConstraints.gridx = 0;
		lConstraints.gridy = 1;
		lConstraints.gridwidth = 1;
		lConstraints.weightx = 0.5;

		getContentPane().add( fIncrement, lConstraints );

		fDecrement = new JButton( "Dec" );
		fDecrement.addActionListener( e-> decrement() );
		lConstraints.gridx = 1;

		getContentPane().add( fDecrement, lConstraints );

		pack();

		// add fView, row 0, column 0, 2 column width
		// add fIncrement, row 1, column 0, 1 column wide
		// add fDecrement, row 1, column 1, 1 column wide
		// pack layout

		// align JFrame to center of screen
		Dimension lScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension lWindowSize = getSize();
		Point lTopLeft = new Point( 
			( lScreenSize.width  - lWindowSize.width  ) / 2,
			( lScreenSize.height - lWindowSize.height ) / 2
		);

		setLocation( lTopLeft );

		// enable/disable buttons based on counter value
		fIncrement.setEnabled( fView.getValue() < CounterCanvas.MAX );
		fDecrement.setEnabled( fView.getValue() > 0 );
	}
}

