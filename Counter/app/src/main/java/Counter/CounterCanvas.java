
package Counter;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class CounterCanvas extends Canvas
{
	private static final long serialVersionUID = 11;
	public  static final int MAX  = 10;
	public  static final int SIZE = 200; // canvas size
	public  static final int CIRCLE_WIDTH = 20;

	private int fCurrentValue;
	private Font fValueFont;

	// constructor, set preffed size and counter value
	// you may want to also use a font object
	public CounterCanvas() {}

	public int getValue() {}
	public void increment() {}
	public void decrement() {}

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
	public void paint( Graphics g ) {}
}

