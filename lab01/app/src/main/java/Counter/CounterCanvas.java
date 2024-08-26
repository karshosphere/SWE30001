
package Counter;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class CounterCanvas extends Canvas
{
	private static final long serialVersionUID = 1L;
	public  static final int MAX  = 10;
	public  static final int SIZE = 200; // canvas size
	public  static final int CIRCLE_WIDTH = 20;

	private int fCurrentValue;
	private Font fValueFont;

	// constructor, set preffed size and counter value
	// you may want to also use a font object
	public CounterCanvas()
	{
		super();
		setPreferredSize( new Dimension( SIZE, SIZE ) );
		fCurrentValue = MAX;
		fValueFont = new Font( "Arial", Font.BOLD, 96 );
	}

	public int getValue()
	{
		return fCurrentValue;
	}

	public void increment()
	{
		if ( fCurrentValue < MAX )
		{
			fCurrentValue++;

			repaint();
		}
	}

	public void decrement()
	{
		if ( fCurrentValue > 0 )
		{
			fCurrentValue--;

			repaint();
		}
	}


	public void update( Graphics g )
	{
		paint( g ); // repaint canvas
	}

	// repaint the counter canvas
	// z-order:
	//	1. clear background
	//	2. draw count arc
	//	3. draw background circle
	//	4. draw number
	public void paint( Graphics g )
	{
		// clear the background
		g.setColor( getBackground() );
		g.fillRect( 0, 0, getWidth(), getHeight() );

		g.setColor( Color.BLUE );

		// increments of 36degrees; 0 degrees at 3 o'clock
		// negative angle clockwise rotation
		g.fillArc( 5, 5, SIZE-10, SIZE-10, 90, -fCurrentValue*36 );

		// remove the innser circle by drawing a smaller arch with background
		// colour
		g.setColor( getBackground() );

		// strong edges can cause bleeding pixles, add 1gree to inner arc
		g.fillArc(
			5+CIRCLE_WIDTH, 5+CIRCLE_WIDTH,
			SIZE-2*(5+CIRCLE_WIDTH), SIZE-2*(5+CIRCLE_WIDTH),
			90, -fCurrentValue*36-1
		);

		// draw center lines
		g.setColor( Color.RED );
		g.drawLine( getWidth()/2, 0, getWidth()/2, getHeight() );
		g.drawLine( 0, getHeight()/2, getWidth(), getHeight()/2 );

		// draw the string
		g.setFont( fValueFont );

		FontMetrics lFontMetrics = g.getFontMetrics();
		String lValueString = String.valueOf( fCurrentValue );

		int lXPos = ( getWidth() - lFontMetrics.stringWidth( lValueString ) ) / 2;
		int lYPos = ( getHeight() - lFontMetrics.getHeight() ) / 2 +
			lFontMetrics.getAscent();

		g.setColor( Color.BLACK );
		g.drawString( lValueString, lXPos, lYPos );
	}
}

